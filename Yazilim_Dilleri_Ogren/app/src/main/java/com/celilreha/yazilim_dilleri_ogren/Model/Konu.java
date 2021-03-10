package com.celilreha.yazilim_dilleri_ogren.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Konu implements Serializable {
    private int id;
    private int yazilimDilId;
    private String baslik;
    private String dosyaYolu;

    public Konu() {
    }

    public Konu(int id, int yazilimDilId, String baslik, String dosyaYolu) {
        this.id = id;
        this.yazilimDilId = yazilimDilId;
        this.baslik = baslik;
        this.dosyaYolu = dosyaYolu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYazilimDilId() {
        return yazilimDilId;
    }

    public void setYazilimDilId(int yazilimDilId) {
        this.yazilimDilId = yazilimDilId;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getDosyaYolu() {
        return dosyaYolu;
    }

    public void setDosyaYolu(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }

    @NonNull
    @Override
    public String toString() {
        return this.baslik;
    }
}
