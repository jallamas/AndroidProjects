package org.jallamas.customlisthotels;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    Context ctx;
    int layoutPlantilla;
    List<Hotel> hoteles;

    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource);
        this.ctx=context;
        this.layoutPlantilla = resource;
        this.hoteles = objects;
    }

}
