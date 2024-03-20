import java.util.Scanner;

public class Balok {
    private double panjang;
    private double lebar;
    private double tinggi;

    // Constructor
    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public Balok(String balok) {
    }

    public void inputNilai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input panjang: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
    }

    public void luasPermukaan() {
        double hasil = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    public void volume() {
        double hasil = panjang * lebar * tinggi;
        System.out.println("Hasil volume: " + hasil);
    }
}