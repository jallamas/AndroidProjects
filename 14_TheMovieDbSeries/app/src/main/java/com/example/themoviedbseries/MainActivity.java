package com.example.themoviedbseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.viewModel.SeriesViewModel;

public class MainActivity extends AppCompatActivity {
    SeriesViewModel seriesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seriesViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);

        seriesViewModel.getIdSerieSeleccionada().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer idSerie) {

                if(idSerie != null) {
                    Log.d("Entrada a observer","True");
                    Intent i = new Intent(MainActivity.this, DetalleSerieActivity.class);
                    i.putExtra(Constantes.EXTRA_ID_SERIE, idSerie);
                    startActivity(i);
                }
            }
        });
    }
}
