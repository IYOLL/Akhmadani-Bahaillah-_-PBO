public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private int duration;

    // Constructor dengan parameter
    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    // Getter dan setter untuk setiap atribut
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayBooks() {
        System.out.println("Daftar Buku:");
        System.out.println("1. " + this.getTitle() + " by " + this.getAuthor());
    }
}

// Kelas HistoryBook
class HistoryBook extends Book {
    public HistoryBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}

// Kelas StoryBook
class StoryBook extends Book {
    public StoryBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}

// Kelas TextBook
class TextBook extends Book {
    public TextBook(String bookId, String title, String author, String category) {
        super(bookId, title, author, category);
    }
}
