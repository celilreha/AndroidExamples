package com.celilreha.recyclerview_satir_animasyonu.Model;

public class Kisi {
    private String adSoyad;
    private String resimUrl;

    public Kisi() {
    }

    public Kisi(String adSoyad, String resimUrl) {
        this.adSoyad = adSoyad;
        this.resimUrl = resimUrl;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }
}
