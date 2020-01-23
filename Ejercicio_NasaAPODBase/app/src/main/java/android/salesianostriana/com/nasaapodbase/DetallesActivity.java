package android.salesianostriana.com.nasaapodbase;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetallesActivity extends AppCompatActivity {

    ImageView imagenDetalle;
    TextView tituloDetalle, descripcionDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_activity);

        imagenDetalle = findViewById(R.id.imagenDetalle);
        tituloDetalle = findViewById(R.id.tituloDetalles);
        descripcionDetalle = findViewById(R.id.DescripcionDetalles);

        Glide.with(DetallesActivity.this).load(getIntent().getExtras().get("urlFoto").toString()).into(imagenDetalle);
        descripcionDetalle.setText(getIntent().getExtras().get("fotoDesc").toString());
        tituloDetalle.setText(getIntent().getExtras().get("foto").toString());


    }


}