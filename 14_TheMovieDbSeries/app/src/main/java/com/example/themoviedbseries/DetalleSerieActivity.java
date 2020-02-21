package com.example.themoviedbseries;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.response.SerieDetails;
import com.example.themoviedbseries.viewModel.DetalleSerieViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleSerieActivity extends AppCompatActivity {

    int idSerie;
    DetalleSerieViewModel detalleSerieViewModel;
    SerieDetails serie;
    private TextView tvName, tvOverview;
    private ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_serie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Añadir a favoritos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViews();

        Bundle extras = getIntent().getExtras();
        idSerie = extras.getInt(Constantes.EXTRA_ID_SERIE);

        Toast.makeText(this, "Id: " + idSerie, Toast.LENGTH_SHORT).show();

        detalleSerieViewModel = new ViewModelProvider(this).get(DetalleSerieViewModel.class);
        detalleSerieViewModel.getSerie(idSerie).observe(this, new Observer<SerieDetails>() {
            @Override
            public void onChanged(SerieDetails serieDetails) {
                serie = serieDetails;
                tvName.setText(serie.getOriginalName());
                tvOverview.setText(serie.getOverview());
                Glide.with(MyApp.getContext())
                        .load(serie.getPosterPath())
                        .into(ivPoster);
            }
        });
    }

    private void findViews() {
        ivPoster = findViewById(R.id.imageViewPoster);
        tvName = findViewById(R.id.textViewSerieName);
        tvOverview = findViewById(R.id.textViewOverview);
    }
}
