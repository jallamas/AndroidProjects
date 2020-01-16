package org.jallamas.luismi_customlist_imageeffects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class EffectsAdapter extends ArrayAdapter<Efecto> {

    Context ctx;
    int layoutPlantilla;
    List<Efecto> listaEfectos;

    public EffectsAdapter(@NonNull Context context, int resource, @NonNull List<Efecto> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutPlantilla = resource;
        this.listaEfectos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutPlantilla, parent, false);

        // Rescatar una referencia de cada elemento visual de la plantilla (template)

        ImageView ivImagen = v.findViewById(R.id.imageViewFoto);
        TextView tvEfecto = v.findViewById(R.id.textViewEffect);


        // Obtener los datos del alumno actual que debo dibujar
        Efecto efectoActual = listaEfectos.get(position);
        String efecto = efectoActual.getNombreEfecto();
        String urlFoto = efectoActual.getUrlPhoto();

        // Insertar en los componentes de la plantilla
        // los datos del alumno actual
        tvEfecto.setText(efecto);

        Glide.with(ctx)
                .load(urlFoto)
                .centerCrop()
                .into(ivImagen);

        return v;
    }
}
