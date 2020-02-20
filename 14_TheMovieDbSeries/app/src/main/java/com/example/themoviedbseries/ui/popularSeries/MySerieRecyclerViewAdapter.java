package com.example.themoviedbseries.ui.popularSeries;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.themoviedbseries.DetalleSerieActivity;
import com.example.themoviedbseries.R;
import com.example.themoviedbseries.common.Constantes;
import com.example.themoviedbseries.common.MyApp;
import com.example.themoviedbseries.response.Serie;
import com.example.themoviedbseries.viewModel.SeriesViewModel;

import java.util.List;


public class MySerieRecyclerViewAdapter extends RecyclerView.Adapter<MySerieRecyclerViewAdapter.ViewHolder> {

    Context ctx;
    private List<Serie> mValues;
    SeriesViewModel seriesViewModel;

    public MySerieRecyclerViewAdapter(Context ctx, List<Serie> mValues, SeriesViewModel seriesViewModel) {
        this.ctx = ctx;
        this.mValues = mValues;
        this.seriesViewModel = seriesViewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_serie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(mValues!=null) {
            holder.mItem = mValues.get(position);
            if (holder.mItem.getPosterPath().isEmpty()) {
                Glide.with(ctx)
                        .load(R.drawable.ic_launcher_background)
                        .into(holder.ivCartel);
            } else {
                Glide.with(ctx)
                        .load(holder.mItem.getPosterPath())
                        .into(holder.ivCartel);
            }
            holder.mView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (null != seriesViewModel) {
                        seriesViewModel.setIdSerieSeleccionada(holder.mItem.getId());
                        Toast.makeText(MyApp.getContext(), holder.mItem.getId().toString(), Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(ctx, DetalleSerieActivity.class);
//                        intent.putExtra(Constantes.EXTRA_ID_SERIE, holder.mItem.getId());
//                        ctx.startActivity(intent);
                    }
                }
            });
        }
    }

    public void setData(List<Serie> resultList){
        this.mValues.clear();
        this.mValues = resultList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mValues!=null) {
            return mValues.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivCartel;
        public Serie mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivCartel = view.findViewById(R.id.imageViewSeriePath);
        }
    }
}
