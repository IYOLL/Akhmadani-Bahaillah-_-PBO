import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Mahasiswa> mahasiswaList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        while (true) {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMahasiswa();
                    break;
                case 2:
                    displayMahasiswa();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void addMahasiswa() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa (15 digit): ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("NIM harus terdiri dari 15 digit.");
            return;
        }
        System.out.print("Masukkan jurusan mahasiswa: ");
        String major = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(name, nim, major);
        mahasiswaList.add(mahasiswa);
        System.out.println("Data Mahasiswa berhasil ditambahkan.");
    }

    private static void displayMahasiswa() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("\n===== Data Mahasiswa =====");
            { Mahasiswa.tampilUniversitas();
            }
            for (Mahasiswa mahasiswa : mahasiswaList) {
                System.out.println("Nama: " + mahasiswa.getName() + "\tNIM: " + mahasiswa.getNim() + "\tJurusan: " + mahasiswa.getjurusan());
            }

    }
    }

    private static void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Pilih angka (1-3): ");
    }
}
