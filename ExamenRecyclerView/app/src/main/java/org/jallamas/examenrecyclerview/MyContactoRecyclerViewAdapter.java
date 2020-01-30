package org.jallamas.examenrecyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyContactoRecyclerViewAdapter extends RecyclerView.Adapter<MyContactoRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Contacto> mValues;
    private final IContactoListener mListener;

    public MyContactoRecyclerViewAdapter(Context ctx, List<Contacto> mValues, IContactoListener mListener) {
        this.ctx = ctx;
        this.mValues = mValues;
        this.mListener = mListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contacto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvEstado.setText(holder.mItem.getEstado());
//        holder.tvFotos.setText(holder.mItem.getNumeroFotosSubidas() + " fotos subidas.");
//        holder.tvAmigos.setText(holder.mItem.getNumeroAmigos() + " amigos");
//        holder.tvEdad.setText(holder.mItem.getEdad() + " años");


        Glide.with(ctx)
                .load(holder.mItem.getFotoUrl())
                .into(holder.ivFoto);

        if (holder.mItem.isEstadoOnline()){
            holder.ivOnline.setVisibility(View.GONE);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onContactoClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFoto;
        public final ImageView ivOnline;
        public final TextView tvNombre;
        public final TextView tvEstado;
        public final TextView tvAmigos;
        public final TextView tvFotos;
        public final TextView tvEdad;
        public Contacto mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.imageViewFoto);
            ivOnline = view.findViewById(R.id.imageViewOnline);
            tvNombre = view.findViewById(R.id.textViewNombre);
            tvEstado = view.findViewById(R.id.textViewNombre);
            tvEdad = view.findViewById(R.id.textViewEdad);
            tvAmigos = view.findViewById(R.id.textViewAmigos);
            tvFotos = view.findViewById(R.id.textViewFotos);
        }
    }
}
