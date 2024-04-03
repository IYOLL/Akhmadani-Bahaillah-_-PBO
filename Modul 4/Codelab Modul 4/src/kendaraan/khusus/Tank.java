package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.ShootAble; // Perbaikan nama interface

public class Tank extends Kendaraan implements ShootAble { // Perbaikan nama interface
    @Override
    public void Start() {
        System.out.println("Menyalakan " + this.getName() + " tank");
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getName()); // Tambahkan titik koma di akhir pernyataan
    }

    @Override
    public void Brake() {
        System.out.println("Tank berhenti"); // Tambahkan titik koma di akhir pernyataan
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank menembak " + vehicle); // Sesuaikan parameter dengan yang didefinisikan dalam interface
    }

    @Override
    public void shoot(String vehicle) {

    }
}
