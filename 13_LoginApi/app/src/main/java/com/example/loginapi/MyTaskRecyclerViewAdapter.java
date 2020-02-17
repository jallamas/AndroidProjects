package com.example.loginapi;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loginapi.retrofit.response.ResponseTask;

import java.util.List;


public class MyTaskRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder> {

    private List<ResponseTask> mValues;
    private Context ctx;


    public MyTaskRecyclerViewAdapter(Context contexto,List<ResponseTask> items) {
        mValues = items;
        ctx = contexto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitle.setText(holder.mItem.getTitle());
        holder.tvUserCreate.setText(holder.mItem.getCreatedBy().getFullname());
        holder.tvUserDone.setText(holder.mItem.getRealizedBy().getFullname());
        holder.tvDescription.setText(holder.mItem.getBody());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitle;
        public final TextView tvUserCreate;
        public final TextView tvUserDone;
        public final TextView tvDescription;
        public ResponseTask mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitle = view.findViewById(R.id.textViewTitle);
            tvUserCreate = view.findViewById(R.id.textViewUser);
            tvUserDone = view.findViewById(R.id.textViewUserDone);
            tvDescription = view.findViewById(R.id.textViewDescription);
        }
    }
}
