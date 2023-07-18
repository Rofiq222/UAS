package com.mycompany.manajemenpenjualanbuku;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManajemenPenjualanBuku {

    private double modalAwal;
    private double modalBerjalan;
    private List<Buku> daftarBuku;

    public ManajemenPenjualanBuku(double modalAwal) {
        this.modalAwal = modalAwal;
        this.modalBerjalan = modalAwal;
        this.daftarBuku = new ArrayList<>();
    }

    public void tampilkanLaporanKeuangan() {
        System.out.println("Modal Awal: " + modalAwal);
        System.out.println("Keuntungan Berjalan: " + (modalBerjalan - modalAwal));
    }

    public void tampilkanStokBuku() {
        System.out.println("Stok Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Stok: " + buku.getStok());
            System.out.println();
        }
    }

    public void penjualanBuku() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul buku yang terjual: ");
        String judul = scanner.nextLine();

        Buku buku = cariBuku(judul);
        if (buku != null) {
            System.out.print("Masukkan jumlah buku yang terjual: ");
            int jumlah = scanner.nextInt();

            if (buku.getStok() >= jumlah) {
                buku.kurangiStok(jumlah);
                modalBerjalan += buku.getHargaJual() * jumlah;
                System.out.println("Penjualan berhasil!");
            } else {
                System.out.println("Stok tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void pembelianBuku() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul buku yang dibeli: ");
        String judul = scanner.nextLine();

        Buku buku = cariBuku(judul);
        if (buku != null) {
            System.out.print("Masukkan jumlah buku yang dibeli: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline
            double totalHarga = buku.getHargaBeli() * jumlah;
            if (modalBerjalan >= totalHarga) {
                buku.tambahStok(jumlah);
                modalBerjalan -= totalHarga;
                System.out.println("Pembelian berhasil!");
            } else {
                System.out.println("Modal tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private Buku cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ManajemenPenjualanBuku manajemen = new ManajemenPenjualanBuku(5000000);

        // Menambahkan buku ke daftar buku
        manajemen.daftarBuku.add(new BukuFiksi("Api Tauhid", 150000, 200000, 15));
        manajemen.daftarBuku.add(new BukuNonFiksi("Matematika Dasar", 90000, 150000, 10));
        manajemen.daftarBuku.add(new Majalah("Tabloit Gaol", 30000, 50000, 5, "Edisi Juli 2023"));

        Scanner scanner = new Scanner(System.in);
        String pilihan;

        System.out.println("***********************************************");
        System.out.println("* Sistem Penjualan Buku");
        System.out.println("* By: <Fakhrur Rofiq>, <22201286>");
        System.out.println("***********************************************");
        System.out.println();

        do {
            System.out.println("Silahkan pilih menu:");
            System.out.println("1) Beli Buku   2) Jual Buku   3) Lihat Stok Buku   4) Lihat Laporan Keuangan 5) Exit");
            System.out.println("Pilihan Menu: ");
            pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1":
                    manajemen.pembelianBuku();
                    break;
                case "2":
                    manajemen.penjualanBuku();
                    break;
                case "3":
                    manajemen.tampilkanStokBuku();
                    break;
                case "4":
                    manajemen.tampilkanLaporanKeuangan();
                    break;
                case "5":
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            System.out.println();
        } while (!pilihan.equals("5"));
    }
}
