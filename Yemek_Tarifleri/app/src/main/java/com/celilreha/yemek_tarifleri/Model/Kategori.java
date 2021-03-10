package com.celilreha.yemek_tarifleri.Model;

import java.io.Serializable;

public class Kategori implements Serializable {

    private int id;
    private String ad;
    private String aciklama;
    private int resim;

    public Kategori() {
    }

    public Kategori(int id, String ad, String aciklama, int resim) {
        this.id = id;
        this.ad = ad;
        this.aciklama = aciklama;
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }
}
