package com.deneme.gezginapp.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deneme.gezginapp.R;
import com.deneme.gezginapp.model.Yer;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;

public class YerlerAdapter extends RecyclerView.Adapter<YerlerAdapter.ViewHolder> {
    ArrayList<Yer> yerList;

    public YerlerAdapter(ArrayList<Yer> veriler){
        yerList = veriler;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_home, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Yer yerVerisi = yerList.get(viewHolder.getAdapterPosition());
        viewHolder.textViewBaslik.setText(yerVerisi.getBaslik());
        viewHolder.textViewMetin.setText(yerVerisi.getMetin());
        Picasso
                .get()
                .load(yerVerisi.getResimUrl())
                .fit()
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return yerList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewBaslik;
        TextView textViewMetin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewBaslik = itemView.findViewById(R.id.textViewBaslik);
            textViewMetin = itemView.findViewById(R.id.textViewMetin);
        }
    }
}
