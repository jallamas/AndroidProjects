package com.example.effectsimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    ImageButton btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08;
    String imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView.findViewById(R.id.imageViewMain);
        btn01.findViewById(R.id.imageButtonEffect1);
        btn02.findViewById(R.id.imageButtonEffect2);
        btn03.findViewById(R.id.imageButtonEffect3);
        btn04.findViewById(R.id.imageButtonEffect4);
        btn05.findViewById(R.id.imageButtonEffect5);
        btn06.findViewById(R.id.imageButtonEffect6);
        btn07.findViewById(R.id.imageButtonEffect7);
        btn08.findViewById(R.id.imageButtonEffect8);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn05.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);
        btn08.setOnClickListener(this);

        Glide
                .with(this)
                .load(imagen)
                .into(imageView);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;

        if(b.getId()==btn01.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .into(imageView);
        }else if(b.getId()==btn02.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                    .into(imageView);
        }else if(b.getId()==btn03.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new SepiaFilterTransformation()))
                    .into(imageView);
        }else if(b.getId()==btn04.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new InvertFilterTransformation()))
                    .into(imageView);
        }else if(b.getId()==btn05.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new PixelationFilterTransformation()))
                    .into(imageView);
        }else if(b.getId()==btn06.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new SketchFilterTransformation()))
                    .into(imageView);
        }else if(b.getId()==btn07.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new SwirlFilterTransformation()))
                    .into(imageView);
        }else if(b.getId()==btn08.getId()){
            Glide
                    .with(this)
                    .load(imagen)
                    .apply(RequestOptions.bitmapTransform(new KuwaharaFilterTransformation()))
                    .into(imageView);
        }
    }
}
