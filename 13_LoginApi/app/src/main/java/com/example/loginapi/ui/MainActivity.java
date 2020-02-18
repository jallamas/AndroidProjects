package com.example.loginapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapi.R;
import com.example.loginapi.TaskListActivity;
import com.example.loginapi.common.Constantes;
import com.example.loginapi.common.SharedPreferencesManager;
import com.example.loginapi.retrofit.ServiceGenerator;
import com.example.loginapi.retrofit.request.ReqLogin;
import com.example.loginapi.retrofit.IServicio;
import com.example.loginapi.retrofit.response.ResponseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private IServicio servicio;
    private ServiceGenerator serviceGenerator;
    private EditText etUsername, etPassword;
    private TextView tvRegister;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitInit();
        findViews();
        events();

    }

    private void retrofitInit() {
        serviceGenerator = ServiceGenerator.getInstance();
        servicio = serviceGenerator.getIServicio();
    }

    private void findViews() {
        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        tvRegister = findViewById(R.id.textViewNewUser);
    }

    private void events() {

        loginButton.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id==R.id.login){
                goToLogin();
        } else if (id==R.id.textViewNewUser){
                gotoRegister();
        }
    }

    private void gotoRegister() {
        Intent i =new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(i);
    }

    private void goToLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if(username.isEmpty()){
            etUsername.setError("El nombre de usuario no puede estar vacío");
        }else if(password.isEmpty()){
            etPassword.setError("La contraseña no puede estar vacía");
        }else{
            ReqLogin reqLogin = new ReqLogin(username,password);

            Call<ResponseAuth> call = servicio.doLogin(reqLogin);

            call.enqueue(new Callback<ResponseAuth>() {
                @Override
                public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Login correcto", Toast.LENGTH_SHORT).show();
                        SharedPreferencesManager.setStringValue(Constantes.PREF_TOKEN,response.body().getToken());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_USERNAME,response.body().getUsername());
                        SharedPreferencesManager.setIntegerValue(Constantes.PREF_ID,Integer.parseInt(response.body().getUserId()));
                        finish();
                        Intent i = new Intent(MainActivity.this, TaskListActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(MainActivity.this, "Se produjo un error. Compruebe sus datos de acceso.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseAuth> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Se produjo un problema de conexión", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
