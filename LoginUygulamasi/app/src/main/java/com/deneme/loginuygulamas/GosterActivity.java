package com.deneme.loginuygulamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster);

        Intent intent = getIntent();
        String adres = intent.getStringExtra("adres");

        WebView view = findViewById(R.id.webView);
        view.loadUrl(adres);

        view.setWebViewClient(new WebViewClient());
    }
}
