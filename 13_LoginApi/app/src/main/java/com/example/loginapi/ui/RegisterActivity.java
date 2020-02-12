package com.example.loginapi.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapi.R;
import com.example.loginapi.retrofit.IServicio;
import com.example.loginapi.retrofit.ServiceGenerator;

public class RegisterActivity extends AppCompatActivity {

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

    private void events() {
    }

    private void findViews() {
        etEmail = findViewById(R.id.email_register);
    }

    private void retrofitInit() {
        serviceGenerator = ServiceGenerator.getInstance();
        servicio = serviceGenerator.getIServicio();
    }
}
