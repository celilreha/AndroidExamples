package com.celilreha.yazilim_dilleri_ogren.Model;

import java.io.Serializable;

public class Yazilim_Dili implements Serializable {
    private String baslik;
    private String aciklama;
    private int resim;
    private int id;

    public Yazilim_Dili() {
    }

    public Yazilim_Dili(String baslik, String aciklama, int resim, int id) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.resim = resim;
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
