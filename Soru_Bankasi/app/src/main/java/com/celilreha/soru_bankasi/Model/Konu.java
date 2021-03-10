package com.celilreha.soru_bankasi.Model;

import java.io.Serializable;

public class Konu implements Serializable {
    private int id;
    private int dersId;
    private String konuAdi;
    private String konuAciklama;
    private int soruSayisi;

    public Konu() {
    }

    public Konu(int id, int dersId, String konuAdi, String konuAciklama, int soruSayisi) {
        this.id = id;
        this.dersId = dersId;
        this.konuAdi = konuAdi;
        this.konuAciklama = konuAciklama;
        this.soruSayisi = soruSayisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public String getKonuAdi() {
        return konuAdi;
    }

    public void setKonuAdi(String konuAdi) {
        this.konuAdi = konuAdi;
    }

    public String getKonuAciklama() {
        return konuAciklama;
    }

    public void setKonuAciklama(String konuAciklama) {
        this.konuAciklama = konuAciklama;
    }

    public int getSoruSayisi() {
        return soruSayisi;
    }

    public void setSoruSayisi(int soruSayisi) {
        this.soruSayisi = soruSayisi;
    }
}
