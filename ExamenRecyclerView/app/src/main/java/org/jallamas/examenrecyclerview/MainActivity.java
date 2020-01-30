package org.jallamas.examenrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IContactoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onContactoClick(Contacto c) {
        Intent i = new Intent(MainActivity.this, DetalleContactoActivity.class);

        i.putExtra("nombre", c.getNombre());
        i.putExtra("edad", c.getEdad());
        i.putExtra("foto", c.getFotoUrl());
        i.putExtra("amigos", c.getNumeroAmigos());
        i.putExtra("numerofotos", c.getNumeroFotosSubidas());

        startActivity(i);
    }
}
