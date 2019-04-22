package com.deneme.loginuygulamas;

public class Gazete {
    public int resimId;
    public String Adi;
    public String WebAdresi;


    @Override
    public String toString() {
        //return super.toString();
        return  Adi + " " + WebAdresi;
    }
}
