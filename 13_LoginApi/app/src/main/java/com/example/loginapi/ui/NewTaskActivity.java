package com.example.loginapi.ui;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.loginapi.retrofit.AuthServiceGenerator;
import com.example.loginapi.retrofit.AuthServicio;
import com.example.loginapi.retrofit.IServicio;
import com.example.loginapi.retrofit.ServiceGenerator;
import com.example.loginapi.retrofit.request.ReqNewTask;
import com.example.loginapi.retrofit.response.ResponseAuth;
import com.example.loginapi.retrofit.response.ResponseTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private AuthServicio servicio;
    private AuthServiceGenerator serviceGenerator;
    private EditText tvTask, tvDescription;
    private Button btnNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        retrofitInit();
        findViews();
        events();
    }

    private void retrofitInit() {
        serviceGenerator = AuthServiceGenerator.getInstance();
        servicio = serviceGenerator.getAuthServicio();
    }

    private void findViews() {
        tvTask = findViewById(R.id.textViewTitle);
        tvDescription = findViewById(R.id.textViewDescription);
        btnNewTask = findViewById(R.id.buttonNewTask);
    }

    private void events() {
        btnNewTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        goToNewTask();
    }

    private void goToNewTask() {
        String title = String.valueOf(tvTask.getText());
        String body = String.valueOf(tvDescription.getText());

        if(title.isEmpty()){
            tvTask.setError("El nombre de la tarea no puede estar vacío");
        }else if(body.isEmpty()){
            tvDescription.setError("Ha de introducir una descripción");
        }else{
            ReqNewTask reqNewTask = new ReqNewTask(title,body,null,null);

            Call<ResponseTask> call = servicio.newTask(reqNewTask);
            call.enqueue(new Callback<ResponseTask>() {
                @Override
                public void onResponse(Call<ResponseTask> call, Response<ResponseTask> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(NewTaskActivity.this, "Tarea creada", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(NewTaskActivity.this, "Se produjo un error. Compruebe sus datos de acceso.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseTask> call, Throwable t) {
                    Toast.makeText(NewTaskActivity.this, "Se produjo un problema de conexión", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
