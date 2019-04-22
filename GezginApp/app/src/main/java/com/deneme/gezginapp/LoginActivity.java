package com.deneme.gezginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Button btnKayitOl = findViewById(R.id.buttonKayitOl);
        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        Button btnGirisYap = findViewById(R.id.buttonGirisYap);
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEposta = findViewById(R.id.editTextEposta);
                EditText editTextSifre = findViewById(R.id.editTextSifre);

                String eposta = editTextEposta.getText().toString();
                if(TextUtils.isEmpty(eposta)){
                    Toast.makeText(LoginActivity.this, "Lütfen eposta giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sifre = editTextSifre.getText().toString();
                if(TextUtils.isEmpty(sifre)){
                    Toast.makeText(LoginActivity.this, "Lütfen şifre giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(eposta, sifre).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Lütfen bilgileri kontrol ediniz", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
