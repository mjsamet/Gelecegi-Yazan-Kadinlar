package com.deneme.mediauygulamasi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Button btnGonder = findViewById(R.id.btnGonder);
        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNumara = findViewById(R.id.editTextNumara);
                String numara = editTextNumara.getText().toString();

                EditText editTextMesaj = findViewById(R.id.editTextMesaj);
                String mesaj = editTextMesaj.getText().toString();

                Uri uri = Uri.parse("smsto:" + numara);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("sms_body", mesaj);
                startActivity(intent);
            }
        });
    }
}
