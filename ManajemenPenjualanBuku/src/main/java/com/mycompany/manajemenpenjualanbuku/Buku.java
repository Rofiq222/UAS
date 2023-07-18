/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemenpenjualanbuku;

/**
 *
 * @author Lenovo
 */
class Buku {

    protected String judul;
    protected double hargaBeli;
    protected double hargaJual;
    protected int stok;

    public Buku(String judul, double hargaBeli, double hargaJual, int stok) {
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stok = stok;
    }

    public String getJudul() {
        return judul;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        stok -= jumlah;
        if (stok < 0) {
            stok = 0;
        }
    }
}

class BukuFiksi extends Buku {

    public BukuFiksi(String judul, double hargaBeli, double hargaJual, int stok) {
        super(judul, hargaBeli, hargaJual, stok);
    }
}

class BukuNonFiksi extends Buku {

    public BukuNonFiksi(String judul, double hargaBeli, double hargaJual, int stok) {
        super(judul, hargaBeli, hargaJual, stok);
    }
}

class Majalah extends Buku {

    private String nomorEdisi;

    public Majalah(String judul, double hargaBeli, double hargaJual, int stok, String nomorEdisi) {
        super(judul, hargaBeli, hargaJual, stok);
        this.nomorEdisi = nomorEdisi;
    }

    public String getNomorEdisi() {
        return nomorEdisi;
    }
}

