package com.rksingh.squareoff.Adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rksingh.squareoff.Model;
import com.rksingh.squareoff.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder>{

    private List<Model> dataList;
    private Context context;

    public CustomAdapter(List<Model> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Model data = dataList.get(position);


        holder.name.setText(data.getName());

        Glide.with(context)
                .load(data.getImg())
                .into(holder.image);

        if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            holder.slug.setText(data.getSlug());
            holder.status.setText(data.getStatus());
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, slug,status;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.iv_imageView);
            name = itemView.findViewById(R.id.tv_name);
            slug = itemView.findViewById(R.id.tv_slug);
            status = itemView.findViewById(R.id.tv_status);
        }
    }

}
