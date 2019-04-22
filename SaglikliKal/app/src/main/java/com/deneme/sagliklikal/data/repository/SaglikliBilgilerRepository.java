package com.deneme.sagliklikal.data.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.deneme.sagliklikal.data.contracts.SaglikliBilgilerContract;
import com.deneme.sagliklikal.data.model.SaglikliBilgi;

public class SaglikliBilgilerRepository {
    private SQLiteDatabase _database;

    public SaglikliBilgilerRepository(SQLiteDatabase db){
        _database = db;
    }

    public SaglikliBilgi GetSaglikliBilgi(){
        Cursor cursor = _database.query(SaglikliBilgilerContract.TABLE_NAME,
                new String[]{SaglikliBilgilerContract.COLUMNS.RESIM, SaglikliBilgilerContract.COLUMNS.BASLIK, SaglikliBilgilerContract.COLUMNS.METIN},
                null, null, null, null, "RANDOM()", "1");

        if(cursor.moveToNext()){
            SaglikliBilgi bilgi = new SaglikliBilgi();
            bilgi.setResim(cursor.getInt(0));
            bilgi.setBaslik(cursor.getString(1));
            bilgi.setMetin(cursor.getString(2));

            cursor.close();
            return bilgi;
        }

        //eğer veri yoksa
        cursor.close();
        return null;
    }
}
