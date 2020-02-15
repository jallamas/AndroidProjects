package com.example.themoviedbseries;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.themoviedbseries.response.Result;

import java.util.List;


public class MySerieRecyclerViewAdapter extends RecyclerView.Adapter<MySerieRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private List<Result> mValues;

    public MySerieRecyclerViewAdapter(Context ctx, List<Result> mValues) {
        this.ctx = ctx;
        this.mValues = mValues;
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
        }
    }

    public void setData(List<Result> resultList){
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
        public Result mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivCartel = view.findViewById(R.id.imageViewSeriePath);
        }
    }
}
