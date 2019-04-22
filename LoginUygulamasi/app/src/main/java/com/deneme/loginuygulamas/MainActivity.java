package com.deneme.loginuygulamas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIptal = findViewById(R.id.buttonIptal);
        btnIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(MainActivity.this, "İptale tıkladınız", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Button btnGirisYap = findViewById(R.id.buttonGirisYap);
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://gelecegiyazanlar.turkcell.com.tr"));
                startActivity(intent);
                return;
               /* TextView txtMail = findViewById(R.id.editTextMail);
                String mail = txtMail.getText().toString();

                TextView txtSifre = findViewById(R.id.editTextSifre);
                String sifre = txtSifre.getText().toString();

                Toast.makeText(MainActivity.this, mail + " " + sifre, Toast.LENGTH_SHORT).show();

                String dogruMail = "a";
                String dogruSifre = "b";

                if(mail.equals( dogruMail) && sifre.equals(dogruSifre)){
                    Toast.makeText(MainActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(MainActivity.this, GazeteActivity.class);
                    intent.putExtra("mail", mail);
                    intent.putExtra("sifre", sifre);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Hatalı giriş. Tekrar deneyin", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }
}
