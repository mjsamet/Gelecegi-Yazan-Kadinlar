package com.deneme.sagliklikal.data.model;

import java.util.Date;

public class KiloGecmisi {
    private int _id;
    private int kilo;
    private int boy;
    private double indeks;
    private Date tarih;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public double getIndeks() {
        return indeks;
    }

    public void setIndeks(double indeks) {
        this.indeks = indeks;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
}
