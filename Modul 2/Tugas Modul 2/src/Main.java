import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        Admin admin = new Admin();
        Student student = new Student();

        while (isRunning) {
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.menuAdmin();
                    break;
                case 2:
                    student.menuStudent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Kode tidak valid. Coba lagi.");
            }
        }
    }
}