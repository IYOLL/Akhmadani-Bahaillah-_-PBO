import java.util.Scanner;

public class Student {
    private String[][] bookList = {
            {"|| 1", "101", "Akhmadani", "Avatar", "Fiction", "10"},
            {"|| 2", "102", "Bayu Aji", "Naruto", "Fantasy", "20"},
            {"|| 3", "103", "Dhiaulhaq", "Azab", "Horror", "5"}
    };

    private String[][] borrowedBooks = new String[0][6];

    public void displayBooks() {
        System.out.println("========================================================================");
        System.out.println("|| No\tBook ID\tPenulis\t\t\tJudul\t\t\tKategori\tStock     ||");
        System.out.println("========================================================================");
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\t" + book[5]);
        }
        System.out.println("========================================================================");
    }

    public void logout() {
        System.out.println("Logged out.\n");
    }

    public void borrowBook(String bookId) {
        for (String[] book : bookList) {
            if (bookId.equals(book[1])) {
                if (Integer.parseInt(book[5]) > 0) {
                    String[] newBook = new String[6];
                    System.arraycopy(book, 0, newBook, 0, 6);
                    newBook[5] = String.valueOf(Integer.parseInt(newBook[5]) - 1);
                    String[] newBorrowedBook = new String[6];
                    System.arraycopy(book, 0, newBorrowedBook, 0, 6);
                    borrowedBooks = append(borrowedBooks, newBorrowedBook);
                    System.out.println("Buku berhasil dipinjam.\n");
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.\n");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.\n");
    }


    public String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }

    public void displayBorrowedBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStatus");
        for (String[] book : borrowedBooks) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\tBorrowed");
        }
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. Pilihan Buku");
            System.out.println("2. Tampilkan Buku yang dipinjam");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Keluar");
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
                    scanner.nextLine(); // Consume newline
                    borrowBook(scanner.nextLine());
                    break;
                case 4:
                    logout();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }
}
