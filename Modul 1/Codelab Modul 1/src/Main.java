import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = scanner.nextLine();

        System.out.print("Jenis Kelamin (L/P) : ");
        String jenisKelaminInput = scanner.nextLine();
        String jenisKelamin;
        if (jenisKelaminInput.equalsIgnoreCase("L")) {
            jenisKelamin = "Laki-laki";
        } else if (jenisKelaminInput.equalsIgnoreCase("P")) {
            jenisKelamin = "Perempuan";
        } else {
            System.out.println("Input tidak valid.");
            return;
        }

        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        String tanggalLahirInput = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirInput);
        Period periode = Period.between(tanggalLahir, LocalDate.now());

        System.out.println("Nama : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelamin);
        System.out.println("Umur Anda : " + periode.getYears() + " tahun " + periode.getMonths() + " bulan");
    }
}