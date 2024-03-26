import java.util.Scanner;
import java.util.ArrayList;


public class User {
    private String[][] bookList = {
            {"|| 1", "101", "Bahaillah", "Avatar", "Fiction", "10"},
            {"|| 2", "102", "Saitama yu", "Naruto", "Fantasy", "0"},
            {"|| 3", "103", "Odasensei", "Azab", "Horror", "5"}
    };

    private String[][] borrowedBooks = new String[0][7];

    private String[][] userStudent = {};

    private final String admin_username = "admin";
    private final String admin_password = "admin";

    public void displayBooks() {
        System.out.println("Daftar Buku yang Tersedia Setelah Penambahan:");
        System.out.println("========================================================================");
        System.out.println("|| No\tBook ID\tPenulis\t\t\tJudul\t\t\tKategori\tStock     ||");
        System.out.println("========================================================================");
        for (int i = 0; i < bookList.length; i++) {
            String[] book = bookList[i];
            System.out.println("|| " + (i + 1) + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\t" + book[5]);
        }
        System.out.println("========================================================================");
    }

    public void addBook(String[] newBook) {
        // Periksa apakah buku dengan ID yang sama sudah ada dalam daftar buku
        for (String[] book : bookList) {
            if (book[1].equals(newBook[1])) {
                System.out.println("Buku dengan ID " + newBook[1] + " sudah ada dalam daftar buku.");
                return;
            }
        }

        // Jika buku belum ada dalam daftar, tambahkan buku baru
        bookList = append(bookList, newBook);
        System.out.println("Buku berhasil ditambahkan.");

        // Membersihkan duplikat dari daftar buku
        bookList = removeDuplicateBooks(bookList);

        // Tampilkan daftar buku yang telah diperbarui
        displayBooks();
    }

    private String[][] removeDuplicateBooks(String[][] bookList) {
        // Buat daftar sementara untuk menyimpan buku unik
        ArrayList<String[]> uniqueBooks = new ArrayList<>();

        // Tambahkan buku ke daftar unik hanya jika belum ada
        for (String[] book : bookList) {
            boolean isDuplicate = false;
            for (String[] uniqueBook : uniqueBooks) {
                if (uniqueBook[1].equals(book[1])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueBooks.add(book);
            }
        }

        // Konversi daftar unik kembali ke array 2D
        return uniqueBooks.toArray(new String[0][]);
    }

    public void borrowBook(String bookId) {
        Scanner scanner = new Scanner(System.in);
        for (String[] book : bookList) {
            if (bookId.equals(book[1])) {
                if (bookId.equals("102") && Integer.parseInt(book[5]) == 0) {
                    System.out.println("Stok Buku Kosong! Silahkan pilih yang lain.\n");
                    return;
                }
                if (Integer.parseInt(book[5]) > 0) {
                    System.out.print("Masukkan jumlah hari peminjaman: ");
                    int daysToBorrow = scanner.nextInt();

                    String[] newBook = new String[6];
                    System.arraycopy(book, 0, newBook, 0, 6);
                    newBook[5] = String.valueOf(Integer.parseInt(newBook[5]) - 1);
                    String[] newBorrowedBook = new String[7]; // Menambahkan 1 index untuk menyimpan jumlah hari peminjaman
                    System.arraycopy(book, 0, newBorrowedBook, 0, 6);
                    newBorrowedBook[6] = String.valueOf(daysToBorrow); // Menyimpan jumlah hari peminjaman
                    borrowedBooks = append(borrowedBooks, newBorrowedBook);
                    System.out.println("Buku berhasil dipinjam. Stok buku " + book[3] + " tersisa " + newBook[5] + ".\n");

                    // Mengurangi stok buku dalam bookList
                    book[5] = String.valueOf(Integer.parseInt(book[5]) - 1);
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.\n");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.\n");
    }



        public void displayBorrowedBooks() {
        System.out.println("=======================================================================");
        System.out.println("|| No || Book ID || Author || Title || Category || Status || Duration ||");
        System.out.println("=======================================================================");
        for (String[] book : borrowedBooks) {
            System.out.println("|| " + book[0] + " || " + book[1] + " || " + book[2] + " || " + book[3] + " || " + book[4] + " || Borrowed || " + book[6] + " ||");
        }
        System.out.println("=======================================================================");
    }

    public void returnBook(String bookId) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (bookId.equals(borrowedBooks[i][1])) {
                // Mengembalikan buku ke daftar buku dan menambah stok buku
                String[] returnedBook = borrowedBooks[i];
                bookList = append(bookList, returnedBook);
                // Menambah stok buku sesuai dengan jumlah buku yang dikembalikan
                for (String[] book : bookList) {
                    if (bookId.equals(book[1])) {
                        book[5] = String.valueOf(Integer.parseInt(book[5]) + 1);
                        System.out.println("Buku berhasil dikembalikan. Stok buku " + book[3] + " bertambah menjadi " + book[5] + ".\n");
                        break; // Keluar dari loop setelah menambah stok buku
                    }
                }
                borrowedBooks = removeBook(borrowedBooks, i);
                return;
            }
        }
        System.out.println("Buku tidak ditemukan dalam daftar yang dipinjam.\n");
    }

    private String[][] removeBook(String[][] borrowedBooks, int index) {
        String[][] newArray = new String[borrowedBooks.length - 1][];
        int newIndex = 0;
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (i != index) {
                newArray[newIndex++] = borrowedBooks[i];
            }
        }
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
            System.out.println("2. Tambahkan Buku");
            System.out.println("3. Tampilkan Mahasiswa Terdaftar");
            System.out.println("4. Tampilkan Buku yang Tersedia");
            System.out.println("5. Logout");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Tambahkan Mahasiswa
                    String nim, nama, jurusan, prodi;
                    scanner.nextLine(); // Membersihkan baris baru yang tersisa di input buffer
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    jurusan = scanner.nextLine();
                    System.out.print("Masukkan Fakultas Mahasiswa: ");
                    prodi = scanner.nextLine();

                    String[] newStudent = {nim, nama, jurusan, prodi};
                    addStudent(newStudent);
                    break;
                case 2:
                    // Tambahkan Buku
                    String[] newBook = new String[6];
                    scanner.nextLine(); // Membersihkan baris baru yang tersisa di input buffer
                    System.out.print("Masukkan Book ID: ");
                    newBook[1] = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    newBook[2] = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    newBook[3] = scanner.nextLine();
                    System.out.print("Masukkan Kategori: ");
                    newBook[4] = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Stock: ");
                    newBook[5] = scanner.nextLine();
                    addBook(newBook);
                    // Tampilkan Buku yang Tersedia
                    System.out.println("\nDaftar Buku yang Tersedia Setelah Penambahan:");
                    displayBooks();
                    break;
                case 3:
                    // Tampilkan Mahasiswa Terdaftar
                    displayStudentList();
                    break;
                case 4:
                    System.out.println("\nDaftar Buku yang Tersedia:");
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Logout Akun Admin.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    public void addStudents(String[][] newStudents) {
        for (String[] newStudent : newStudents) {
            addStudent(newStudent);
        }
    }

    private void addStudent(String[] newStudent) {
        userStudent = append(userStudent, newStudent);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }


    private void displayStudentList() {
        if (userStudent.length > 0) {
            System.out.println("\nList of Registered Students:");
            for (String[] student : userStudent) {
                System.out.println("NIM: " + student[0]);
                System.out.println("Nama: " + student[1]);
                System.out.println("Jurusan: " + student[3]);
                System.out.println("Fakultas: " + student[2]);
                System.out.println(); // Tambahkan baris kosong antara setiap mahasiswa
            }
        } else {
            System.out.println("No students registered yet.");
        }
    }




    public void menuUser() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        String nim;
        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();

// Periksa panjang NIM
        if (nim.length() != 15) {
            System.out.println("NIM tidak valid. Harus 15 digit!.\n");
            return;
        }

        while (isRunning) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Pilihan Buku");
            System.out.println("2. Tampilkan Buku yang dipinjam");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Masukkan book ID : ");
                    scanner.nextLine(); // Membersihkan pindah baris yang tersisa
                    borrowBook(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Masukkan book ID untuk mengembalikan buku : ");
                    scanner.nextLine(); // Membersihkan pindah baris yang tersisa
                    returnBook(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Apakah kamu yakin untuk keluar? (Y/T): ");
                    String confirmExit = scanner.next();
                    scanner.nextLine(); // Membersihkan pindah baris yang tersisa
                    if (confirmExit.equalsIgnoreCase("Y")) {
                        System.out.print("Apakah kamu ingin meminjam semua buku yang tersedia sebelum keluar? (Y/T): ");
                        String confirmBorrowAll = scanner.next();
                        scanner.nextLine(); // Membersihkan pindah baris yang tersisa
                        if (confirmBorrowAll.equalsIgnoreCase("Y")) {
                            // Meminjam semua buku yang tersedia
                            System.out.println("Peminjaman buku berhasil dilakukan.");
                        } else if (confirmBorrowAll.equalsIgnoreCase("T")) {
                            System.out.println("Terima kasih.");
                        } else {
                            System.out.println("Pilihan tidak valid. Terima kasih.");
                        }
                        System.out.println("Logged out.\n");
                        isRunning = false;
                    } else if (confirmExit.equalsIgnoreCase("T")) {
                        System.out.println("Keluar dibatalkan.");
                    } else {
                        System.out.println("Pilihan tidak valid. Keluar dibatalkan.");
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    private String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }
}
