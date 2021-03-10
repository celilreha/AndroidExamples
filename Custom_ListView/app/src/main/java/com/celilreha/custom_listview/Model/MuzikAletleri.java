package com.celilreha.custom_listview.Model;

public class MuzikAletleri {
    private int resim;
    private String isim;
    private String aciklama;
    private String renk;
    private String tur;
    private double fiyat;


    /*
    private fieldların üretilmesi
    boş ve dolu constructorlar üretilmesi
    her fielda ait get ve set metot üretilmesi
     */

    public MuzikAletleri() {
    }

    public MuzikAletleri(int resim, String isim, String aciklama, String renk, String tur, double fiyat) {
        this.resim = resim;
        this.isim = isim;
        this.aciklama = aciklama;
        this.renk = renk;
        this.tur = tur;
        this.fiyat = fiyat;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
