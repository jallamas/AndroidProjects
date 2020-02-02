package org.jallamas.loginappprimera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.jallamas.loginappprimera.models.Usuario;
import org.jallamas.loginappprimera.services.LoginService;
import org.jallamas.loginappprimera.services.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService loginService = ServiceGenerator.createService(LoginService.class, "luismi", "12345");
        Call<Usuario> call = loginService.basicLogin();

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    cargarDatos(response.body());
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }

    public void cargarDatos(List<Usuario> list) {
        setListAdapter(
                new ArrayAdapter<Usuario>(
                        this,
                        android.R.layout.simple_list_item_1,
                        list
                )
        );
    }

}
