package com.deneme.loginuygulamas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GazeteAdapter extends ArrayAdapter<Gazete> {
    int r;
    public GazeteAdapter(Context context, int resource, List<Gazete> objects) {
        super(context, resource, objects);
        r = resource;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        Gazete veri = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(r, null);
        }

        ImageView image = convertView.findViewById(R.id.imageViewLogo);
        TextView text = convertView.findViewById(R.id.textViewGazeteAdi);

        image.setImageResource(veri.resimId);
        text.setText(veri.Adi);

        return convertView;
    }
}
