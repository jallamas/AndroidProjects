package android.salesianostriana.com.nasaapodbase;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.salesianostriana.com.api.NasaPicture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MypicRecyclerViewAdapter extends RecyclerView.Adapter<MypicRecyclerViewAdapter.ViewHolder> {

    private final List<NasaPicture> listaImagenes;
    private Context ctx;
    private int layout;

    public MypicRecyclerViewAdapter(Context ctx, int layout, List<NasaPicture> objects) {
        this.ctx = ctx;
        this.layout = layout;
        listaImagenes = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = listaImagenes.get(position);
        holder.tvFecha.setText(listaImagenes.get(position).getDate());

        Glide
                .with(ctx)
                .load(listaImagenes.get(position).getUrl())
                .error(R.drawable.ic_error)
                .centerCrop()
                .into(holder.ivFoto);

    }

    @Override
    public int getItemCount() {
        return listaImagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvFecha;
        public final ImageView ivFoto;
        public NasaPicture mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvFecha = view.findViewById(R.id.textViewDate);
            ivFoto = view.findViewById(R.id.imageViewPic);
        }
    }
}
