package com.main;

import kendaraan.Kendaraan;
import kendaraan.khusus.Pesawat;
import kendaraan.khusus.Tank;
import kendaraan.pribadi.Mobil;
import kendaraan.pribadi.Motor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // menyimpan semua object dalam satu array dengan teknik polymorphism
        Kendaraan kendaraan[] = new Kendaraan[4];
        kendaraan[0] = new Motor();
        kendaraan[1] = new Mobil();
        kendaraan[2] = new Tank();
        kendaraan[3] = new Pesawat();

        //saya tambahkan keterangan agar lebih jelas
        System.out.println("1. Kendaraan Ke-1 adalah Motor");
        System.out.println("2. Kendaraan Ke-2 adalah Mobil");
        System.out.println("3. Kendaraan Ke-3 adalah Tank");
        System.out.println("4. Kendaraan Ke-4 adalah Pesawat");

        // input atribut pada setiap object kendaraan
        for (int i = 0; i < kendaraan.length; i++) {
            System.out.printf("Masukkan nama kendaraan ke-%d: ", (i + 1));
            kendaraan[i].setName(input.next());
            System.out.printf("Masukkan model kendaraan ke-%d: ", (i + 1));
            kendaraan[i].setModel(input.next());
            System.out.printf("Masukkan warna kendaraan ke-%d: ", (i + 1));
            kendaraan[i].setWarna(input.next());
            System.out.printf("Masukkan tahun kendaraan ke-%d: ", (i + 1));
            kendaraan[i].setTahun(input.nextInt());
            System.out.println();
        }

        // output pada setiap method di kendaraan
        for (Kendaraan objectKendaraan : kendaraan) {
            objectKendaraan.Start(); // Panggil method Start()

            // Lakukan pengecekan untuk jenis kendaraan
            if (objectKendaraan instanceof Tank){
                Tank tank = (Tank)objectKendaraan;
                tank.Shoot("Truk"); // Panggil method Shoot() jika kendaraan adalah Tank
            } else if(objectKendaraan instanceof Pesawat){
                Pesawat pesawat = (Pesawat)objectKendaraan;
                pesawat.fly(); // Panggil method fly() jika kendaraan adalah Pesawat
            }

            objectKendaraan.Stop(); // Panggil method Stop()
            objectKendaraan.getInfo(); // Panggil method getInfo()
            System.out.println();
        }
    }
}
