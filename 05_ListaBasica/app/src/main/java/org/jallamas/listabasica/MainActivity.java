package org.jallamas.listabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvAlumnos;
    List<String> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAlumnos = findViewById(R.id.listViewAlumnos);

        alumnos = new ArrayList<>();
        alumnos.add("Juanma Calvo");
        alumnos.add("Álvaro Légolas");
        alumnos.add("Miguel Barbas");
        alumnos.add("Daniel Leyenda");
        alumnos.add("Gonzalo Fatiga");
        alumnos.add("José Manuel Christian");
        alumnos.add("Sulfuro Concursante");
        alumnos.add("Alberto Elfo");
        alumnos.add("Lucas Grijander");
        alumnos.add("Esperanza Espe");
        alumnos.add("Alejandro (Adrián bis)");
        alumnos.add("Gonzalo Fatiga");
        

        ArrayAdapter adaptadorAlumnos= new ArrayAdapter<String>(
          this,
          android.R.layout.simple_list_item_1,
          alumnos
        );

        lvAlumnos.setAdapter(adaptadorAlumnos);

        lvAlumnos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Alumno:"+alumnos.get(position), Toast.LENGTH_SHORT).show();
    }
}
