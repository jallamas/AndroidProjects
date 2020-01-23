package android.salesianostriana.com.nasaapodbase;

import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.salesianostriana.com.api.NasaPicture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MypicRecyclerViewAdapter extends RecyclerView.Adapter<MypicRecyclerViewAdapter.ViewHolder> {

    private final List<NasaPicture> mValues;
    private Context ctx;
    private final INasaPictureListener mListener;

    public MypicRecyclerViewAdapter(List<NasaPicture> mValues,Context context, INasaPictureListener listener) {
        this.mValues = mValues;
        this.ctx = context;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvFecha.setText(mValues.get(position).getDate());

        holder.ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.mView.getContext() ,DetallesActivity.class );

                i.putExtra("urlFoto", holder.mItem.getUrl());
                i.putExtra("fotoDesc", holder.mItem.getExplanation());
                i.putExtra("foto", holder.mItem.getTitle());

                ctx.startActivity(i);
            }
        });

        if (holder.mItem.getUrl().contains("youtube")){
            Glide
                    .with(ctx)
                    .load(mValues.get(position).getUrl())
                    .error(R.drawable.youtube)
                    .centerCrop()
                    .into(holder.ivFoto);
            holder.ivFoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(holder.mItem.getUrl()));
                    try {
                        ctx.startActivity(webIntent);
                    } catch (ActivityNotFoundException ex) {
                    }
                }
            });
        }else {
            Glide
                    .with(ctx)
                    .load(mValues.get(position).getUrl())
                    .error(R.drawable.spinner)
                    .centerCrop()
                    .into(holder.ivFoto);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
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
