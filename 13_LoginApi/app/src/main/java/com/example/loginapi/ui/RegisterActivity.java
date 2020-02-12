package com.example.loginapi.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapi.R;
import com.example.loginapi.common.MyApp;
import com.example.loginapi.retrofit.IServicio;
import com.example.loginapi.retrofit.ServiceGenerator;
import com.example.loginapi.retrofit.request.ReqLogin;
import com.example.loginapi.retrofit.request.ReqRegister;
import com.example.loginapi.retrofit.response.ResponseAuth;
import com.example.loginapi.retrofit.response.ResponseRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private IServicio servicio;
    private ServiceGenerator serviceGenerator;
    private EditText etEmail, etUsername, etPassword, etPassword2;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        retrofitInit();
        findViews();
        events();

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
    }

    private void events() {
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id==R.id.register){
            register();
        }
    }

    private void register() {
        String email = etEmail.getText().toString();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String password2 = etPassword2.getText().toString();


        if(email.isEmpty()){
            etEmail.setError("El email no puede estar vacío");
        }else if(username.isEmpty()){
            etUsername.setError("El nombre de usuario no puede estar vacío");
        }else if(password.isEmpty()){
            etPassword.setError("La contraseña no puede estar vacía");
        }else if(password2.isEmpty()){
            etPassword2.setError("La contraseña no puede estar vacía");
        }else{
            ReqRegister reqRegister = new ReqRegister(email,username,password,password2);

            Call<ResponseRegister> call = servicio.doRegister(reqRegister);

            call.enqueue(new Callback<ResponseRegister>() {
                @Override
                public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "El usuario se registró correctamente", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Se produjo un error. Compruebe sus datos de registro.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseRegister> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Se produjo un problema de conexión", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
