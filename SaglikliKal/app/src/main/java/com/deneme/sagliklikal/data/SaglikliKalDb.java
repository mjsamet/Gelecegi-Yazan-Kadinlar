package com.deneme.sagliklikal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.deneme.sagliklikal.R;
import com.deneme.sagliklikal.data.contracts.KiloGecmisiTableContract;
import com.deneme.sagliklikal.data.contracts.SaglikliBilgilerContract;
import com.deneme.sagliklikal.data.contracts.UrunKalorileriContract;
import com.deneme.sagliklikal.data.model.UrunKalori;

public class SaglikliKalDb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sagliklikal.db";
    public static final int DATABASE_VERSION = 1;

    public SaglikliKalDb( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String koliGecmisiSQL = "CREATE TABLE " + KiloGecmisiTableContract.TABLE_NAME + " (" +
                KiloGecmisiTableContract.COLUMNS._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                KiloGecmisiTableContract.COLUMNS.BOY + " INTEGER NOT NULL, " +
                KiloGecmisiTableContract.COLUMNS.KILO + " INTEGER NOT NULL, " +
                KiloGecmisiTableContract.COLUMNS.INDEKS + " REAL NOT NULL, " +
                KiloGecmisiTableContract.COLUMNS.TARIH + " INTEGER NOT NULL);";

        String saglikliBilgilerSQL = "CREATE TABLE " + SaglikliBilgilerContract.TABLE_NAME + " (" +
                SaglikliBilgilerContract.COLUMNS._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                SaglikliBilgilerContract.COLUMNS.RESIM + " INTEGER NOT NULL," +
                SaglikliBilgilerContract.COLUMNS.BASLIK + " TEXT NOT NULL," +
                SaglikliBilgilerContract.COLUMNS.METIN + " TEXT NOT NULL);";

        String urunKalorileriSQL = "CREATE TABLE " + UrunKalorileriContract.TABLE_NAME + " (" +
                UrunKalorileriContract.COLUMNS._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                UrunKalorileriContract.COLUMNS.RESIM + " INTEGER NOT NULL, " +
                UrunKalorileriContract.COLUMNS.KALORI + " INTEGER NOT NULL, " +
                UrunKalorileriContract.COLUMNS.URUN + " TEXT NOT NULL);";

        db.execSQL(koliGecmisiSQL);
        db.execSQL(saglikliBilgilerSQL);
        db.execSQL(urunKalorileriSQL);

        ContentValues elmaKalori = new ContentValues();
        elmaKalori.put(UrunKalorileriContract.COLUMNS.RESIM, R.drawable.satir1);
        elmaKalori.put(UrunKalorileriContract.COLUMNS.KALORI, 52);
        elmaKalori.put(UrunKalorileriContract.COLUMNS.URUN, "Elma 100gr");

        ContentValues erikKalori = new ContentValues();
        erikKalori.put(UrunKalorileriContract.COLUMNS.RESIM, R.drawable.satir1);
        erikKalori.put(UrunKalorileriContract.COLUMNS.KALORI, 46);
        erikKalori.put(UrunKalorileriContract.COLUMNS.URUN, "Erik 100gr");

        db.insert(UrunKalorileriContract.TABLE_NAME, null, elmaKalori);
        db.insert(UrunKalorileriContract.TABLE_NAME, null, erikKalori);

        ContentValues ilkSatir = new ContentValues();
        ilkSatir.put(SaglikliBilgilerContract.COLUMNS.RESIM, R.drawable.satir1);
        ilkSatir.put(SaglikliBilgilerContract.COLUMNS.BASLIK, "İLK SATIR BAŞLIĞI");
        ilkSatir.put(SaglikliBilgilerContract.COLUMNS.METIN, "İLK SATIR METİN İÇERİĞİ. UZUN BİR METİN OLMALI");

        ContentValues ikinciSatir = new ContentValues();
        ikinciSatir.put(SaglikliBilgilerContract.COLUMNS.RESIM, R.mipmap.ic_launcher);
        ikinciSatir.put(SaglikliBilgilerContract.COLUMNS.BASLIK, "İKİNCİ SATIR BAŞLIĞI");
        ikinciSatir.put(SaglikliBilgilerContract.COLUMNS.METIN, "İKİNCİ SATIR METİN İÇERİĞİ. UZUN BİR METİN OLMALI");

        db.insert(SaglikliBilgilerContract.TABLE_NAME, null, ilkSatir);
        db.insert(SaglikliBilgilerContract.TABLE_NAME, null, ikinciSatir);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
