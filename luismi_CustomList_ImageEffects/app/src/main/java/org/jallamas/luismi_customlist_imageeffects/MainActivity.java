package org.jallamas.luismi_customlist_imageeffects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvEfectos;
    List<Efecto> efectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEfectos = findViewById(R.id.listViewEfects);

        efectos = new ArrayList<>();



    EffectsAdapter adapter= new EffectsAdapter(
        this,
        R.layout.lista_images_item,
        efectos
    );

    lvEfectos.setAdapter(adapter);
    }
}
