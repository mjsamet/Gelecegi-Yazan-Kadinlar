package com.deneme.sagliklikal;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.deneme.sagliklikal.data.SaglikliKalDb;
import com.deneme.sagliklikal.data.repository.KiloGecmisiRepository;
import com.deneme.sagliklikal.data.repository.SaglikliBilgilerRepository;
import com.deneme.sagliklikal.data.repository.UrunKalorileriRepository;

public class App extends Application {

    private SaglikliKalDb saglikliKalDb;
    private KiloGecmisiRepository kiloGecmisiRepository;
    private SaglikliBilgilerRepository saglikliBilgilerRepository;
    private SQLiteDatabase database;
    private UrunKalorileriRepository urunKalorileriRepository;


    @Override
    public void onCreate() {
        super.onCreate();
        saglikliKalDb = new SaglikliKalDb(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        database.close();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        database.close();
        database = null;
        kiloGecmisiRepository = null;
        saglikliBilgilerRepository = null;
    }

    private SQLiteDatabase getDatabase(){
        if(database == null)
            database = saglikliKalDb.getWritableDatabase();

        return database;
    }

    public KiloGecmisiRepository GetKiloGecmisiRepository(){
        if(kiloGecmisiRepository == null)
            kiloGecmisiRepository = new KiloGecmisiRepository(getDatabase());

        return kiloGecmisiRepository;
    }

    public SaglikliBilgilerRepository GetSaglikliBilgilerRepository()
    {
        if(saglikliBilgilerRepository == null)
            saglikliBilgilerRepository = new SaglikliBilgilerRepository(getDatabase());

        return saglikliBilgilerRepository;
    }

    public UrunKalorileriRepository GetUrunKalorileriRepository()
    {
        if(urunKalorileriRepository == null)
            urunKalorileriRepository = new UrunKalorileriRepository(getDatabase());

        return urunKalorileriRepository;
    }
}
