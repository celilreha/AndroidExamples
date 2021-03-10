package com.celilreha.soru_bankasi.Model;

import java.io.Serializable;

public class Ders implements Serializable {
    private int id;
    private String dersAdi;
    private String dersAciklama;
    private String renk;
    private int konuSayisi;
    private int soruSayisi;

    public Ders() {
    }

    public Ders(int id, String dersAdi, String dersAciklama, String renk, int konuSayisi, int soruSayisi) {
        this.id = id;
        this.dersAdi = dersAdi;
        this.dersAciklama = dersAciklama;
        this.renk = renk;
        this.konuSayisi = konuSayisi;
        this.soruSayisi = soruSayisi;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getDersAciklama() {
        return dersAciklama;
    }

    public void setDersAciklama(String dersAciklama) {
        this.dersAciklama = dersAciklama;
    }

    public int getKonuSayisi() {
        return konuSayisi;
    }

    public void setKonuSayisi(int konuSayisi) {
        this.konuSayisi = konuSayisi;
    }

    public int getSoruSayisi() {
        return soruSayisi;
    }

    public void setSoruSayisi(int soruSayisi) {
        this.soruSayisi = soruSayisi;
    }
}
