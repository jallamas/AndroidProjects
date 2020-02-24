package org.jallamas.contactlistapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

public class ContactoAdapter extends ArrayAdapter<Contacto> {
    Context ctx;
    int layoutPlantilla;
    List<Contacto> contactos;

    public ContactoAdapter(@NonNull Context context, int resource, @NonNull List<Contacto> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutPlantilla = resource;
        this.contactos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutPlantilla, parent, false);


        TextView tvNombre = v.findViewById(R.id.textViewName);
        TextView tvEmail = v.findViewById(R.id.textViewEmail);
        TextView tvTelefono = v.findViewById(R.id.textViewPhone);
        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);

        Contacto contactoActual = contactos.get(position);
        tvNombre.setText(contactoActual.getNombre());
        tvEmail.setText(contactoActual.getEmail());
        tvTelefono.setText(contactoActual.getTelefono());

        if (contactoActual.getPhoto()!=null) {

            Glide.with(ctx)
                    .load(contactoActual.getPhoto())
                    .centerCrop()
                    .into(ivPhoto);
        }else{
            Glide.with(ctx)
                    .load(android.R.mipmap.sym_def_app_icon)
                    .centerCrop()
                    .into(ivPhoto);
        }
        return v;
    }
}
