package org.jallamas.customlisthotels;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    Context ctx;
    int layoutPlantilla;
    List<Hotel> hoteles;

    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutPlantilla = resource;
        this.hoteles = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutPlantilla, parent, false);

        // Rescatar una referencia de cada elemento visual de la plantilla (template)
        TextView tvNombre = v.findViewById(R.id.textViewHotel);
        TextView tvOfferPrice = v.findViewById(R.id.textViewOfferPrice);
        TextView tvPrice = v.findViewById(R.id.textViewNormalPrice);
        TextView tvRate = v.findViewById(R.id.textViewRating);
        RatingBar ratingBar = v.findViewById(R.id.ratingBarHotel);
        ImageView ivPhoto = v.findViewById(R.id.imageViewHotel);

        // Obtener los datos del hotel actual que debo dibujar
        Hotel hotelActual = hoteles.get(position);
        String hotel = hotelActual.getNombre();
        String urlPhoto = hotelActual.getPhotoUrl();
        int offerPrice = hotelActual.getOfferPrice();
        int price = hotelActual.getPrice();
        float rate = hotelActual.getRate();

        // Insertar en los componentes de la plantilla
        // los datos del hotel actual
        tvNombre.setText(hotel);
        tvOfferPrice.setText(String.valueOf(offerPrice));
        tvPrice.setText(String.valueOf(price));
        tvPrice.setPaintFlags(tvPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        tvRate.setText(String.valueOf(rate));
        ratingBar.setRating(rate);

        Glide.with(ctx)
                .load(urlPhoto)
                .centerCrop()
                .into(ivPhoto);

        return v;
    }
}
