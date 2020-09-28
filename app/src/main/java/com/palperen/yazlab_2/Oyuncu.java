package com.palperen.yazlab_2;

public class Oyuncu {
    public static int no=1;
    private int oyuncuNo;
    private String oyuncuAd;
    private int oyuncuPuan;

    public Oyuncu() {
    }

    public Oyuncu(String oyuncuAd) {
        this.oyuncuAd = oyuncuAd;
        this.oyuncuNo=no;
        no++;
    }

    public int getOyuncuNo() {
        return oyuncuNo;
    }

    public void setOyuncuNo(int oyuncuNo) {
        this.oyuncuNo = oyuncuNo;
    }

    public String getOyuncuAd() {
        return oyuncuAd;
    }

    public void setOyuncuAd(String oyuncuAd) {
        this.oyuncuAd = oyuncuAd;
    }

    public int getOyuncuPuan() {
        return oyuncuPuan;
    }

    public void setOyuncuPuan(int oyuncuPuan) {
        this.oyuncuPuan = oyuncuPuan;
    }
}
