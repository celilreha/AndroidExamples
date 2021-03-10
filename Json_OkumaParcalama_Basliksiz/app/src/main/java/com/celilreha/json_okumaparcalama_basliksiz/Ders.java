package com.celilreha.json_okumaparcalama_basliksiz;

public class Ders {
    private String ad;
    private int saat;
    private int sinif;

    public Ders() {
    }

    public Ders(String ad, int saat, int sinif) {
        this.ad = ad;
        this.saat = saat;
        this.sinif = sinif;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
    }
}
