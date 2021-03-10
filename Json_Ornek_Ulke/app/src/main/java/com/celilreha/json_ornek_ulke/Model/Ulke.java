package com.celilreha.json_ornek_ulke.Model;

public class Ulke {
    private String ad;
    private String baskent;
    private String bayrak;
    private String paraBirimi;

    public Ulke() {
    }

    public Ulke(String ad, String baskent, String bayrak, String paraBirimi) {
        this.ad = ad;
        this.baskent = baskent;
        this.bayrak = bayrak;
        this.paraBirimi = paraBirimi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBaskent() {
        return baskent;
    }

    public void setBaskent(String baskent) {
        this.baskent = baskent;
    }

    public String getBayrak() {
        return bayrak;
    }

    public void setBayrak(String bayrak) {
        this.bayrak = bayrak;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }
}
