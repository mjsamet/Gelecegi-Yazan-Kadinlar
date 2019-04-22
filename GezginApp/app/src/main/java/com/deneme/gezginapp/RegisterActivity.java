package com.deneme.gezginapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnKayitOl = findViewById(R.id.buttonKayitOl);

        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEposta = findViewById(R.id.editTextEposta);
                EditText editTextSifre = findViewById(R.id.editTextSifre);
                EditText editTextSifreTekrar = findViewById(R.id.editTextSifreTekrar);

                String eposta = editTextEposta.getText().toString();
                if(TextUtils.isEmpty(eposta)){
                    Toast.makeText(RegisterActivity.this, "Lütfen eposta giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sifre = editTextSifre.getText().toString();
                if(TextUtils.isEmpty(sifre)){
                    Toast.makeText(RegisterActivity.this, "Lütfen şifre giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sifreTekrar = editTextSifreTekrar.getText().toString();
                if(TextUtils.isEmpty(sifreTekrar)){
                    Toast.makeText(RegisterActivity.this, "Lütfen şifreyi tekrar giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.equals(sifre, sifreTekrar) == false){
                    Toast.makeText(RegisterActivity.this, "Lütfen aynı şifreler giriniz", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(eposta, sifre).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Üye olma başarılı", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(RegisterActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if(e instanceof FirebaseAuthException){
                            FirebaseAuthException hata = (FirebaseAuthException)e;
                            if(hata.getErrorCode().contentEquals("ERROR_WEAK_PASSWORD")){
                                Toast.makeText(RegisterActivity.this, "Zayıf şifre", Toast.LENGTH_SHORT).show();
                            }else if(hata.getErrorCode().contentEquals("ERROR_INVALID_EMAIL")){
                                Toast.makeText(RegisterActivity.this, "Lütfen düzgün bir email adresi giriniz", Toast.LENGTH_SHORT).show();
                            }
                            else if(hata.getErrorCode().contentEquals("ERROR_EMAIL_ALREADY_IN_USE")){
                                Toast.makeText(RegisterActivity.this, "Bu eposta ile daha önceden kayıt olunmuş", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}
