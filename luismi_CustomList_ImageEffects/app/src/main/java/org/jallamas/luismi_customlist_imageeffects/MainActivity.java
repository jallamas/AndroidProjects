package org.jallamas.luismi_customlist_imageeffects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

public class MainActivity extends AppCompatActivity {
    ListView lvEfectos;
    List<Efecto> efectos;
    String photoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvEfectos = findViewById(R.id.listViewEfects);
        new RandomImageTask(this).execute();

    }

    private class RandomImageTask extends AsyncTask<String, Void, String> {

        private MainActivity myActivity;
        private String client_id = "285e73380f4b940744dfb04ce6816d56a0d58324479398790d3950d9da7ca424";

        public RandomImageTask(MainActivity myActivity){
            this.myActivity=myActivity;
        }

        RandomPhotoApi randomApi = new RandomPhotoApi(client_id);

        @Override
        protected String doInBackground(String... strings) {
            return randomApi.getRandomPhoto();
        }

        @Override
        protected void onPostExecute(String s) {
            photoUrl=s;
            lvEfectos = findViewById(R.id.listViewEfects);
            efectos=new ArrayList<>();
            efectos.add(new Efecto (photoUrl,"Original", null));
            efectos.add(new Efecto (photoUrl,"Toon",new ToonFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Sepia",new SepiaFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Contrast",new ContrastFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Invert",new InvertFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Pixelation",new PixelationFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Sketch",new SketchFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Swirl",new SwirlFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Brightness",new BrightnessFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Kuwahara",new KuwaharaFilterTransformation()));
            efectos.add(new Efecto (photoUrl,"Vignetes",new VignetteFilterTransformation()));

            EffectsAdapter adapter= new EffectsAdapter(
                    MainActivity.this,
                    R.layout.lista_images_item,
                    efectos
            );

            lvEfectos.setAdapter(adapter);
        }
    }
}
