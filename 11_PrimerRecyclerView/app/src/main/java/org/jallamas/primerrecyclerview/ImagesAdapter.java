package org.jallamas.primerrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;


import java.util.List;

class ImagesAdapter extends ArrayAdapter<String> {

    Context ctx;
    int layoutPlantilla;
    List<String> imagenes;

    public ImagesAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutPlantilla = resource;
        this.imagenes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutPlantilla, parent, false);

        // Rescatar una referencia de cada elemento visual de la plantilla (template)

        ImageView ivImagen = v.findViewById(R.id.imageViewFoto);

        // Obtener los datos de la imagen actual que debo dibujar
        final String fotoActual =imagenes.get(position);

        // Insertar en los componentes de la plantilla
        // los datos de la imagen actual

                Glide.with(ctx)
                    .load(fotoActual)
                    .into(ivImagen);

        ivImagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(ctx,Activity2.class);
                i.putExtra("foto",fotoActual);
                ctx.startActivity(i);

            }
        });
        return v;
    }
}
