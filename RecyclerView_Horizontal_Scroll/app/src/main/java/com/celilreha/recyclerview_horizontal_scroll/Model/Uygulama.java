package com.celilreha.recyclerview_horizontal_scroll.Model;

public class Uygulama {
    private int id;
    private String baslik;
    private String resimUrl;

    public Uygulama() {
    }

    public Uygulama(int id, String baslik, String resimUrl) {
        this.id = id;
        this.baslik = baslik;
        this.resimUrl = resimUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }
}
