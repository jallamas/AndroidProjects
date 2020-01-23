package android.salesianostriana.com.nasaapodbase;

import android.os.Bundle;
import android.salesianostriana.com.api.NasaPicture;

import androidx.appcompat.app.AppCompatActivity;

public class HistoricoActivity extends AppCompatActivity implements INasaPictureListener {

    @Override
    public void onNasaPictureClick(NasaPicture r) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historicoactivity);
    }
}
