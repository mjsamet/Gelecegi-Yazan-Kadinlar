package com.deneme.sagliklikal.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deneme.sagliklikal.R;
import com.deneme.sagliklikal.data.model.UrunKalori;

import java.util.ArrayList;

public class UrunKalorileriAdapter extends RecyclerView.Adapter<UrunKalorileriAdapter.ViewHolder> {
    private ArrayList<UrunKalori> list;

    public UrunKalorileriAdapter(ArrayList<UrunKalori> l){
        list = l;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_kalori, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UrunKalori k = list.get(viewHolder.getAdapterPosition());

        viewHolder.textViewKalori.setText(k.getKalori()+"");
        viewHolder.textViewUrun.setText(k.getUrun());
        viewHolder.imageView.setImageResource(k.getResim());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewUrun, textViewKalori;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewUrun = itemView.findViewById(R.id.textViewUrun);
            textViewKalori = itemView.findViewById(R.id.textViewKalori);
        }
    }
}
