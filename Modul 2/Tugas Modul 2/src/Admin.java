import java.util.Scanner;

public class Admin {
    private String[][] userStudent = {
    };

    private final String admin_username = "admin";
    private final String admin_password = "admin";

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String nim, name, faculty, programStudy;

        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();

        if (nim.length() != 15) {
            System.out.println("NIM tidak valid. Harus 15 digit!.");
            return;
        }

        System.out.print("Masukkan Nama: ");
        name = scanner.nextLine();

        System.out.print("Masukkan Fakultas: ");
        faculty = scanner.nextLine();

        System.out.print("Masukkan Mata Kuliah: ");
        programStudy = scanner.nextLine();

        userStudent = addToArray(userStudent, nim, name, faculty, programStudy);

        System.out.println("Mahasiswa Berhasil mendaftar.");
    }

    public String[][] displayStudent() {
        System.out.println("==================================================");
        System.out.println("NIM\t\t\t\tName\tFaculty\t\tProgram Study");
        System.out.println("--------------------------------------------------");
        for (String[] student: userStudent) {
            System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t\t\t" + student[3]);
        }
        System.out.println("==================================================");
        return userStudent;
    }

    public String[][] addToArray(String[][] array, String nim, String name, String faculty, String programStudy) {
        String[][] newArray = new String[array.length + 1][];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = new String[]{nim, name, faculty, programStudy};

        return newArray;
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.print("Masukkan username (admin): ");
        username = scanner.nextLine();

        System.out.print("Masukkan password (admin): ");
        password = scanner.nextLine();

        if (!username.equals(admin_username) || !password.equals(admin_password)) {
            System.out.println("Username atau password salah.\n");
            return;
        }

        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambahkan Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logout.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }
}
