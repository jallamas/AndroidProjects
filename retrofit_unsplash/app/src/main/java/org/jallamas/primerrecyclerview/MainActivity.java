package org.jallamas.primerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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

    ListView lvImagenes;
    List<String> imagenes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvImagenes = findViewById(R.id.listaImagenes);
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
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            imagenes.add(randomApi.getRandomPhoto());
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            ImagesAdapter adapter= new ImagesAdapter(
                    MainActivity.this,
                    R.layout.lista_imagenes_item,
                    imagenes
            );

            lvImagenes.setAdapter(adapter);
        }
    }
}
