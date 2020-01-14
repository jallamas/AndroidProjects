package org.jallamas.vintagetoycam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btnNext;
    int n=0;

    List<String> imagenes= Arrays.asList("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Mosque_Cordoba.jpg/270px-Mosque_Cordoba.jpg",
            "http://www.turjaen.org/sites/default/files/catedral.jpg",
            "http://www.españaescultura.es/export/sites/cultura/multimedia/galerias/monumentos/alcazaba_almeria_t0400035.jpg_1306973099.jpg",
            "https://cdn.civitatis.com/espana/roquetas-de-mar/galeria/alhambra.jpg",
            "https://www.marbenjoparking.com/wp-content/uploads/2019/10/catedral-de-malaga-1080x675.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqnGDqApK1vv5uT1Zq_QKd5E3Mv-2LL7NrOX0Xxi-Bi51hEDZx&s",
            "https://upload.wikimedia.org/wikipedia/commons/4/43/MonumentoFeDescubridora.jpg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnNext = findViewById(R.id.buttonNext);

        btnNext.setOnClickListener(this);

        Glide
                .with(this)
                .load(imagenes.get(n))
                .into(imageView);
    }

    @Override
    public void onClick(View v) {

        n=(n+1)%imagenes.size();
        Glide
            .with(this)
            .load(imagenes.get(n))
            .into(imageView);

    }
}
