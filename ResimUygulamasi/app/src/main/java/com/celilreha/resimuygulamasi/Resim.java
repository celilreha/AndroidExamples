package com.celilreha.resimuygulamasi;

public class Resim {
    private int id;
    private String resimBaslik;
    private int resim;

    public Resim() {
    }

    public Resim(int id, String resimBaslik, int resim) {
        this.id = id;
        this.resimBaslik = resimBaslik;
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResimBaslik() {
        return resimBaslik;
    }

    public void setResimBaslik(String resimBaslik) {
        this.resimBaslik = resimBaslik;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }
}
