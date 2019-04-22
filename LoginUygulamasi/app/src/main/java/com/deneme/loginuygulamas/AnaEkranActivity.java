package com.deneme.loginuygulamas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AnaEkranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        Intent intent = getIntent();
        String mail = intent.getStringExtra("mail");

        TextView textViewMail = findViewById(R.id.textViewMail);
        textViewMail.setText(mail);

        ListView listView = findViewById(R.id.listUlke);
        final ArrayList<String> ulkeler = new ArrayList<>();
        ulkeler.add("Türkiye");
        ulkeler.add("İngiltere");
        ulkeler.add("Yunanistan");
        ulkeler.add("Yunanistan1");
        ulkeler.add("Yunanistan2");
        ulkeler.add("Yunanistan3");
        ulkeler.add("Yunanistan4");
        ulkeler.add("Yunanistan5");
        ulkeler.add("Yunanistan6");
        ulkeler.add("Yunanistan7");
        ulkeler.add("Yunanistan8");
        ulkeler.add("Yunanistan9");
        ulkeler.add("Yunanistan10");
        ulkeler.add("Yunanistan11");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(AnaEkranActivity.this, android.R.layout.simple_list_item_1,
                ulkeler);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final String ulke = ulkeler.get(position);
                Toast.makeText(AnaEkranActivity.this, ulke, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(AnaEkranActivity.this);
                builder.setTitle("BAŞLIK");
                builder.setMessage(ulke);
                builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(AnaEkranActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}
