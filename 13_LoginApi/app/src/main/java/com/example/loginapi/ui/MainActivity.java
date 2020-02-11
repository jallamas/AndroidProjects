package com.example.loginapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapi.R;
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
    private Button loginButton;
    private ReqLogin reqLogin;
    private Context context;

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
    }

    private void events() {
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id==R.id.login){
                goToLogin();
        }
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
