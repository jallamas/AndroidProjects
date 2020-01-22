package android.salesianostriana.com.nasaapodbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.salesianostriana.com.api.NasaApi;
import android.salesianostriana.com.api.NasaPicture;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    ImageView mainFoto;
    TextView fecha,titulo,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFoto = findViewById(R.id.imageViewMain);
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
        protected void onPreExecute(){
            Glide
                    .with(MainActivity.this)
                    .load(R.drawable.ic_spinner)
                    .centerCrop()
                    .into(mainFoto);
        }

        @Override
        protected NasaPicture doInBackground(String... strings) {
            return nasaApi.getPicOfToday();
        }

        @Override
        protected void onPostExecute(NasaPicture s) {
            //Joda Formatting
            String rawDate = s.getDate();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
            DateTime jodatime = dtf.parseDateTime(rawDate);
            DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd-MM-yyyy");
            fecha.setText(dtfOut.print(jodatime)+"\n Seleccione otra fecha");

//            if (s.getUrl().contains("youtube")){
//                mainFoto.setVisibility(View.GONE);
//                Toast.makeText(myActivity, "Luismi tiene el código secreto", Toast.LENGTH_LONG).show();
//            }else {
                Glide
                        .with(MainActivity.this)
                        .load(s.getUrl())
                        .error(R.drawable.ic_error)
                        .centerCrop()
                        .into(mainFoto);
//            }
            titulo.setText(s.getTitle());
            description.setText(s.getExplanation());
        }
    }
}
