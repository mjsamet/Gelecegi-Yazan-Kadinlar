package com.deneme.sagliklikal.data.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.deneme.sagliklikal.data.contracts.KiloGecmisiTableContract;
import com.deneme.sagliklikal.data.model.KiloGecmisi;

public class KiloGecmisiRepository {

    private SQLiteDatabase _database;

    public KiloGecmisiRepository(SQLiteDatabase db){
        _database = db;
    }


    public void Add(KiloGecmisi data){
        ContentValues values = new ContentValues();
        values.put(KiloGecmisiTableContract.COLUMNS.KILO, data.getKilo());
        values.put(KiloGecmisiTableContract.COLUMNS.BOY, data.getBoy());
        values.put(KiloGecmisiTableContract.COLUMNS.INDEKS, data.getIndeks());
        values.put(KiloGecmisiTableContract.COLUMNS.TARIH, data.getTarih().getTime());

      _database.insert(KiloGecmisiTableContract.TABLE_NAME, null, values);
    }


    public KiloGecmisi GetLast(){
        Cursor cursor = _database.query(KiloGecmisiTableContract.TABLE_NAME,
                new String[]{KiloGecmisiTableContract.COLUMNS.KILO, KiloGecmisiTableContract.COLUMNS.BOY}
        ,null, null, null, null,
                KiloGecmisiTableContract.COLUMNS._ID + " DESC", "1");

        if(cursor.moveToNext()){
            KiloGecmisi kiloGecmisi = new KiloGecmisi();
            kiloGecmisi.setKilo(cursor.getInt(0));
            kiloGecmisi.setBoy(cursor.getInt(1));
            cursor.close();
            return kiloGecmisi;
        }

        cursor.close();
        return null;
    }
}
