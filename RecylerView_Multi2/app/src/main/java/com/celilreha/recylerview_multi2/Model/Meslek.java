package com.celilreha.recylerview_multi2.Model;

public class Meslek {

    private String baslik;
    private int resim;

    public Meslek() {
    }

    public Meslek(String baslik, int resim) {
        this.baslik = baslik;
        this.resim = resim;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }
}
