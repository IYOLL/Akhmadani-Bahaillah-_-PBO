import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> mahasiswaList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String input;
        int i = 1;

        while (true) {
            System.out.print("Masukkan nama ke-" + i + ": ");
            input = scanner.nextLine();

            try {
                if (input.equalsIgnoreCase("selesai")) {
                    break;
                } else if (input.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                } else {
                    mahasiswaList.add(input);
                    i++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Daftar mahasiswa yang diinputkan:");
        for (String nama : mahasiswaList) {
            System.out.println(nama);
        }
    }
}
