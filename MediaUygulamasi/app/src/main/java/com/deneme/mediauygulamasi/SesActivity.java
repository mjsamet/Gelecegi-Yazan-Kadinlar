package com.deneme.mediauygulamasi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class SesActivity extends AppCompatActivity {

    MediaRecorder recorder;
    final String filePath = Environment.getExternalStorageDirectory().getPath() + "/kayit.3gp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ses);

        Button btnKaydet = findViewById(R.id.btnKaydet);
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(SesActivity.this, Manifest.permission.RECORD_AUDIO);
                int result1 = ContextCompat.checkSelfPermission(SesActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(result != PackageManager.PERMISSION_GRANTED || result1 != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(SesActivity.this,
                            new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            100);
                    return;
                }
                recorder = new MediaRecorder();
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
                recorder.setOutputFile(filePath);

                try {
                    recorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                recorder.start();
                Toast.makeText(SesActivity.this, "Kayıt başladı", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnDurdur = findViewById(R.id.btnDurdur);
        btnDurdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorder.stop();

                Toast.makeText(SesActivity.this, "Kayıt durdu", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = new MediaPlayer();
                player.setVolume(1,1);
                try {
                    player.setDataSource(filePath);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean yetkiAldikMi = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        if(yetkiAldikMi == true)
            Toast.makeText(this, "Yetki aldık", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Yetki alamadık", Toast.LENGTH_SHORT).show();
    }
}
