package com.celilreha.soru_bankasi.Model;

import java.io.Serializable;

public class Soru implements Serializable {
    private int id;
    private int konuId;
    private String resim;
    private String baslik;
    private String yanitA;
    private String yanitB;
    private String yanitC;
    private String yanitD;
    private char dogruYanit;

    public Soru() {
    }

    public Soru(int id, int konuId, String resim, String baslik, String yanitA, String yanitB, String yanitC, String yanitD, char dogruYanit) {
        this.id = id;
        this.konuId = konuId;
        this.resim = resim;
        this.baslik = baslik;
        this.yanitA = yanitA;
        this.yanitB = yanitB;
        this.yanitC = yanitC;
        this.yanitD = yanitD;
        this.dogruYanit = dogruYanit;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKonuId() {
        return konuId;
    }

    public void setKonuId(int konuId) {
        this.konuId = konuId;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYanitA() {
        return yanitA;
    }

    public void setYanitA(String yanitA) {
        this.yanitA = yanitA;
    }

    public String getYanitB() {
        return yanitB;
    }

    public void setYanitB(String yanitB) {
        this.yanitB = yanitB;
    }

    public String getYanitC() {
        return yanitC;
    }

    public void setYanitC(String yanitC) {
        this.yanitC = yanitC;
    }

    public String getYanitD() {
        return yanitD;
    }

    public void setYanitD(String yanitD) {
        this.yanitD = yanitD;
    }

    public char getDogruYanit() {
        return dogruYanit;
    }

    public void setDogruYanit(char dogruYanit) {
        this.dogruYanit = dogruYanit;
    }
}
