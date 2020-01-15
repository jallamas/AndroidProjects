package org.jallamas.customlisthotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvHoteles;
    List<Hotel>listaHoteles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHoteles = findViewById(R.id.listViewHoteles);
        listaHoteles=new ArrayList<>();
        listaHoteles.add(new Hotel("Meliá Sevilla",
                "https://content.r9cdn.net/rimg/himg/b5/b0/68/sembo-E-H33124-52604570_z.jpg_resizeMode=FitInside_formatSettings=jpeg(quality-90)-862514.jpg?width=568&height=350&crop=true&caller=HotelDetailsPhoto",4.5f,255,199));
        listaHoteles.add(new Hotel("Los Lebreros","https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/itemimages/40/48/40485_v8.jpeg",4f,198,133));
        listaHoteles.add(new Hotel("Hotel Colón","https://cdn.quierohotel.com/hotel-melia-colon-PF882_1.jpg",5f,300,255));

        HotelAdapter adapter = new HotelAdapter(
                this,
                R.layout.lista_hoteles_item,
                listaHoteles
        );

        lvHoteles.setAdapter(adapter);
    }
}
