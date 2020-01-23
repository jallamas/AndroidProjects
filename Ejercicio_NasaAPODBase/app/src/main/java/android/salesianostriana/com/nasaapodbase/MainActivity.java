package android.salesianostriana.com.nasaapodbase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.salesianostriana.com.api.NasaApi;
import android.salesianostriana.com.api.NasaPicture;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity implements ISeleccionarFechaListener{

    ImageView mainFoto;
    TextView fecha,titulo,description,youtube;
    Button historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFoto = findViewById(R.id.imageViewMain);
        fecha = findViewById(R.id.textViewFecha);
        titulo = findViewById(R.id.textViewTitulo);
        description = findViewById(R.id.textViewDescription);
        historico = findViewById(R.id.buttonHistory);
        youtube = findViewById(R.id.textViewYoutube);

        fecha.setOnClickListener((v)->{ mostrarCalendario(v); });

        new NasaPicTask().execute();

    }

    public void mostrarCalendario(View view) {
        DialogFragment newFragment = DateSelectFragment.newInstance(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onFechaSeleccionada(int year, int month, int day) {
        new NasaPicTask(year,month,day).execute();
    }

    private class NasaPicTask extends AsyncTask<String, Void, NasaPicture> {

        private int year,month,day;

        public NasaPicTask(int year, int month, int day) {
            this.year = year;
            this.month = month+1;
            this.day = day;
        }

        public NasaPicTask() {
            this.year = 0;
            this.month = 0;
            this.day = 0;
        }

        NasaApi nasaApi = new NasaApi("dJLaK1IQk9N3fnNCam84bO9TZshz7su8k23doMLi");

        @Override
        protected void onPreExecute(){
            Glide
                    .with(MainActivity.this)
                    .load(R.drawable.spinner)
                    .centerCrop()
                    .into(mainFoto);
        }

        @Override
        protected NasaPicture doInBackground(String... strings) {

            if (year==0){
                return nasaApi.getPicOfToday();
            }else{
                return nasaApi.getPicOfAnyDate(year+"-"+month+"-"+day);
            }

        }

        @Override
        protected void onPostExecute(NasaPicture s) {
            //Joda Formatting
            String rawDate = s.getDate();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
            DateTime jodatime = dtf.parseDateTime(rawDate);
            DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd-MM-yyyy");
            fecha.setText(dtfOut.print(jodatime)+"\n Seleccione otra fecha");

            if (s.getUrl().contains("youtube")){
                mainFoto.setVisibility(View.GONE);
                youtube.setVisibility(View.VISIBLE);

                youtube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(s.getUrl()));
                        try {
                            MainActivity.this.startActivity(webIntent);
                        } catch (ActivityNotFoundException ex) {
                        }
                    }
                });

            }else {
                mainFoto.setVisibility(View.VISIBLE);
                youtube.setVisibility(View.GONE);
                Glide
                        .with(MainActivity.this)
                        .load(s.getUrl())
                        .error(R.drawable.ic_error)
                        .centerCrop()
                        .into(mainFoto);
            }
            titulo.setText(s.getTitle());
            description.setText(s.getExplanation());
        }
    }
}
