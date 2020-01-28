package org.jallamas.primerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jallamas.primerrecyclerview.generator.ServiceGenerator;
import org.jallamas.primerrecyclerview.models.UnSplashPhoto;
import org.jallamas.primerrecyclerview.services.UnSplashService;

import java.io.IOException;
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
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UnSplashService service = ServiceGenerator.createService(UnSplashService.class);
    private String client_id = "285e73380f4b940744dfb04ce6816d56a0d58324479398790d3950d9da7ca424";
    ListView lvImagenes;
    List<String> imagenes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvImagenes = findViewById(R.id.listaImagenes);

        new RandomImageTask().execute(client_id);
    }

    public void cargarDatos(List<UnSplashPhoto> list) {
//        setListAdapter(
//                new ArrayAdapter<UnSplashPhoto>(
//                        this,
//                        android.R.layout.simple_list_item_1,
//                        list
//                )
//        );
    }

    private class RandomImageTask extends AsyncTask<String, Void, List<UnSplashPhoto>> {

        @Override
        protected List<UnSplashPhoto> doInBackground(String... strings) {
            List<UnSplashPhoto> resultado=null;

            Call<List<UnSplashPhoto>> callPhotos = service.randomImages(strings[0]);

            Response<List<UnSplashPhoto>> responsePhotos = null;

            try {
                responsePhotos = callPhotos.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (responsePhotos.isSuccessful()) {
                resultado = responsePhotos.body();
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(List<UnSplashPhoto> photos) {

            if (photos != null) {
                cargarDatos(photos);
            }
        }
    }
}
