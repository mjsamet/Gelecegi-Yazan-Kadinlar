package com.deneme.sagliklikal.data.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.deneme.sagliklikal.data.contracts.UrunKalorileriContract;
import com.deneme.sagliklikal.data.model.UrunKalori;

import java.util.ArrayList;

public class UrunKalorileriRepository {
    SQLiteDatabase _database;

    public UrunKalorileriRepository(SQLiteDatabase db){
        _database = db;
    }

    public ArrayList<UrunKalori> GetAll(){
        Cursor cursor = _database.query(UrunKalorileriContract.TABLE_NAME,
                new String[]{UrunKalorileriContract.COLUMNS.RESIM, UrunKalorileriContract.COLUMNS.URUN, UrunKalorileriContract.COLUMNS.KALORI},
                null, null, null, null, null);

        ArrayList<UrunKalori> list = new ArrayList<>();

        while (cursor.moveToNext()){
            UrunKalori k = new UrunKalori();
            k.setResim(cursor.getInt(0));
            k.setUrun(cursor.getString(1));
            k.setKalori(cursor.getInt(2));

            list.add(k);
        }

        cursor.close();
        return list;
    }
}
