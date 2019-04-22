package com.deneme.loginuygulamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GazeteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazete);

        final ArrayList<Gazete> list = new ArrayList<>();
        Gazete sabah = new Gazete();
        sabah.Adi = "SABAH";
        sabah.WebAdresi = "http://m.sabah.com.tr";
        sabah.resimId = R.mipmap.logo;

        Gazete hurriyet = new Gazete();
        hurriyet.Adi = "HÜRRİYET";
        hurriyet.WebAdresi = "http://www.hurriyet.com.tr";
        hurriyet.resimId = R.mipmap.ic_launcher;

        list.add(sabah);
        list.add(hurriyet);

        ListView listView = findViewById(R.id.listGazeteler);
        //ArrayAdapter<Gazete> adapter = new ArrayAdapter<>(GazeteActivity.this, android.R.layout.simple_list_item_1, list);
        GazeteAdapter adapter = new GazeteAdapter(GazeteActivity.this, R.layout.list_item_gazete, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GazeteActivity.this, GosterActivity.class);
                Gazete gazete = list.get(position);
                intent.putExtra("adres", gazete.WebAdresi);
                startActivity(intent);
            }
        });
    }
}
