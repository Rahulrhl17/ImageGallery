package com.example.imagegallery.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.Activities.ImagePopup;
import com.example.imagegallery.Models.results;
import com.example.imagegallery.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private Context context;
    private List<results> results;
    ImagePopup imagePopup;

    public ImageAdapter(Context context, List<com.example.imagegallery.Models.results> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.imageitem,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String thumb = results.get(position).getUrls().getThumb();
        String regular = results.get(position).getUrls().getRegular();
        if(!thumb.equalsIgnoreCase("")){
            Picasso.get().load(thumb).noFade().into(holder.imageView);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup = new ImagePopup(context,regular);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }{

    }
}

