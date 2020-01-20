package android.salesianostriana.com.nasaapodbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.salesianostriana.com.api.NasaApi;
import android.salesianostriana.com.api.NasaPicture;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView urlMainFoto;
    TextView fecha,titulo,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlMainFoto = findViewById(R.id.imageViewMain);
        fecha = findViewById(R.id.textViewFecha);
        titulo = findViewById(R.id.textViewTitulo);
        description = findViewById(R.id.textViewDescription);
        new NasaPicTask(this).execute();
    }

    private class NasaPicTask extends AsyncTask<String, Void, NasaPicture> {

        private MainActivity myActivity;
        private String apiKey="dJLaK1IQk9N3fnNCam84bO9TZshz7su8k23doMLi";

        public NasaPicTask(MainActivity myActivity){
            this.myActivity=myActivity;
        }

        NasaApi nasaApi = new NasaApi(apiKey);

        @Override
        protected NasaPicture doInBackground(String... strings) {
            return nasaApi.getPicOfToday();
        }

        @Override
        protected void onPostExecute(NasaPicture s) {

            Glide
                    .with(MainActivity.this)
                    .load(s.getUrl())
                    .centerCrop()
                    .into(urlMainFoto);

            fecha.setText(s.getDate()+"Seleccione otra fecha");
            titulo.setText(s.getTitle());
            description.setText(s.getExplanation());
        }
    }
}
