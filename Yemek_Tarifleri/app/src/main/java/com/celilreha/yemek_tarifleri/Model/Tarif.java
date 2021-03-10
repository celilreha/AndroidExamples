package com.celilreha.yemek_tarifleri.Model;

import java.io.Serializable;

public class Tarif implements Serializable {
    private int id;
    private int kategoriId;
    private String ad;
    private int resim;
    private String malzemeler;
    private String aciklama;
    private int pisirmeSuresi;
    private int hazirlamaSuresi;
    private int kisiSayisi;

    public Tarif() {
    }

    public Tarif(int id, int kategoriId, String ad, int resim, String malzemeler, String aciklama, int pisirmeSuresi, int hazirlamaSuresi, int kisiSayisi) {
        this.id = id;
        this.kategoriId = kategoriId;
        this.ad = ad;
        this.resim = resim;
        this.malzemeler = malzemeler;
        this.aciklama = aciklama;
        this.pisirmeSuresi = pisirmeSuresi;
        this.hazirlamaSuresi = hazirlamaSuresi;
        this.kisiSayisi = kisiSayisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getPisirmeSuresi() {
        return pisirmeSuresi;
    }

    public void setPisirmeSuresi(int pisirmeSuresi) {
        this.pisirmeSuresi = pisirmeSuresi;
    }

    public int getHazirlamaSuresi() {
        return hazirlamaSuresi;
    }

    public void setHazirlamaSuresi(int hazirlamaSuresi) {
        this.hazirlamaSuresi = hazirlamaSuresi;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }
}
