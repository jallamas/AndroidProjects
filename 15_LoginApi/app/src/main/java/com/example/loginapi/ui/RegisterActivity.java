package com.example.loginapi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.loginapi.R;
import com.example.loginapi.retrofit.IServicio;
import com.example.loginapi.retrofit.ServiceGenerator;
import com.example.loginapi.retrofit.response.ResponseRegister;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int READ_REQUEST_CODE = 42;
    private IServicio servicio;
    private ServiceGenerator serviceGenerator;
    private EditText etEmail, etUsername, etPassword, etPassword2;
    private Button registerButton, avatarButton;
    private ImageView ivAvatar;
    Uri uriSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        retrofitInit();
        findViews();
        events();

        //avatarButton.setEnabled(false);
        uriSelected = null;

    }

    private void retrofitInit() {
        serviceGenerator = ServiceGenerator.getInstance();
        servicio = serviceGenerator.getIServicio();
    }

    private void findViews() {

        etEmail = findViewById(R.id.email_register);
        etUsername = findViewById(R.id.username_register);
        etPassword = findViewById(R.id.password_register);
        etPassword2 = findViewById(R.id.password2_register);
        registerButton = findViewById(R.id.register);
        avatarButton = findViewById(R.id.buttonAvatar);
        ivAvatar = findViewById(R.id.imageViewAvatar);
    }

    private void events() {

        registerButton.setOnClickListener(this);
        avatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performFileSearch();
            }
        });
    }

    private void performFileSearch() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("Filechooser URI", "Uri: " + uri.toString());
                //showImage(uri);
                Glide
                        .with(this)
                        .load(uri)
                        .into(ivAvatar);
                uriSelected = uri;
                avatarButton.setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        register();
    }

    private void register() {
//        String email = etEmail.getText().toString();
//        String username = etUsername.getText().toString();
//        String password = etPassword.getText().toString();
//        String password2 = etPassword2.getText().toString();
//
//        if(email.isEmpty()){
//            etEmail.setError("El email no puede estar vacío");
//        }else if(username.isEmpty()){
//            etUsername.setError("El nombre de usuario no puede estar vacío");
//        }else if(password.isEmpty()){
//            etPassword.setError("La contraseña no puede estar vacía");
//        }else if(password2.isEmpty()){
//            etPassword2.setError("La contraseña no puede estar vacía");
//        }else{
            if (uriSelected != null) {

                try {
                    InputStream inputStream = getContentResolver().openInputStream(uriSelected);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    int cantBytes;
                    byte[] buffer = new byte[1024*4];

                    while ((cantBytes = bufferedInputStream.read(buffer,0,1024*4)) != -1) {
                        baos.write(buffer,0,cantBytes);
                    }
                    RequestBody requestFile =
                            RequestBody.create(
                                    baos.toByteArray(),MediaType.parse(getContentResolver().getType(uriSelected)));

                    MultipartBody.Part body =
                            MultipartBody.Part.createFormData("avatar", "avatar", requestFile);

                    RequestBody email = RequestBody.create(etEmail.getText().toString(),MultipartBody.FORM);
                    RequestBody username = RequestBody.create(etUsername.getText().toString(),MultipartBody.FORM);
                    RequestBody password = RequestBody.create(etPassword.getText().toString(),MultipartBody.FORM);
                    RequestBody password2 = RequestBody.create(etPassword2.getText().toString(),MultipartBody.FORM);
//                ReqRegister reqRegister = new ReqRegister(email,username,password,password2);

                Call<ResponseRegister> call = servicio.doRegister(body, email, username, password, password2);

                call.enqueue(new Callback<ResponseRegister>() {
                    @Override
                    public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "El usuario se registró correctamente", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Se produjo un error. Compruebe sus datos de registro.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRegister> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Se produjo un problema de conexión", Toast.LENGTH_SHORT).show();
                    }
                });
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
