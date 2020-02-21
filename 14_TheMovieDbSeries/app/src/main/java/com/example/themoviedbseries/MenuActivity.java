package com.example.themoviedbseries;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.viewModel.SeriesViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MenuActivity extends AppCompatActivity {
    SeriesViewModel seriesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        seriesViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);

        seriesViewModel.getIdSerieSeleccionada().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer idSerie) {
                if(idSerie != null) {
                    Intent i = new Intent(MyApp.getContext(), DetalleSerieActivity.class);
                    i.putExtra(Constantes.EXTRA_ID_SERIE, idSerie);
                    startActivity(i);
                }
            }
        });
    }

}
