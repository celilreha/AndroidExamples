package com.celilreha.recylerview_multi2.Model;

public class Is_Ilan {
    private String baslik;
    private int maas;
    private String firma;

    public Is_Ilan() {
    }

    public Is_Ilan(String baslik, int maas, String firma) {
        this.baslik = baslik;
        this.maas = maas;
        this.firma = firma;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
