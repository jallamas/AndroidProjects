package org.jallamas.alumnosapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jallamas.alumnosapp.models.Alumno;

import java.util.List;


public class MyAlumnosRecyclerViewAdapter extends RecyclerView.Adapter<MyAlumnosRecyclerViewAdapter.ViewHolder> {

    private final List<Alumno> mValues;
    private Context ctx;
    private int layout;

    public MyAlumnosRecyclerViewAdapter(List<Alumno> mValues, Context ctx, int layout) {
        this.mValues = mValues;
        this.ctx = ctx;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_alumnos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvApellidos.setText(holder.mItem.getApellidos());

        Glide.with(ctx)
                .load(holder.mItem.getFotoUrl())
                .centerCrop()
                .into(holder.IvFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView IvFoto;
        public final TextView tvNombre;
        public final TextView tvApellidos;
        public Alumno mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombre = view.findViewById(R.id.textViewNombre);
            tvApellidos = view.findViewById(R.id.textViewApellidos);
            IvFoto = view.findViewById(R.id.imageViewFoto);
        }
    }
}
