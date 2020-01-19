package org.jallamas.primerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String fotoActual = getIntent().getExtras().getString("foto");
        ImageView fotoDetail =findViewById(R.id.imageViewFotoDetail);

        Glide.with(this)
                .load(fotoActual)
                .into(fotoDetail);
    }
}
