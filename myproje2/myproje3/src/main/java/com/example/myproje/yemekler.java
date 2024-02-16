package com.example.myproje;

public class yemekler {

    private String kullaniciAdi;
    private String isim;
    private String türü;
    private String fiyat;

    public yemekler() {

    }

    public yemekler(String s, String s1, String s2, String s3) {
        this.kullaniciAdi = s;
        this.isim = s1;
        this.türü = s2;
        this.fiyat = s3;
    }


    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void yemekler2(String kullaniciAdi, String isim, String türü, String fiyat){

this.kullaniciAdi=kullaniciAdi;
        this.isim = isim;
        this.türü = türü;
        this.fiyat = fiyat;

    }



    public yemekler( String isim, String türü, String fiyat) {

        this.isim = isim;
        this.türü = türü;
        this.fiyat = fiyat;
    }



    public String getIsim() {

        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTürü() {

        return türü;
    }

    public void setTürü(String türü) {

        this.türü = türü;
    }

    public String getFiyat() {

        return fiyat;
    }

    public void setFiyat(String fiyat) {

        this.fiyat = fiyat;
    }
}
