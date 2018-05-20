package data;

import java.io.Serializable;

public class Books implements Serializable {

    private static int count = 0;
    private int id;
    private String bookTitle;
    private String author;
    private boolean genre;
    private GenreCategory genreCat;
    private String date;
    private String comment;

    public Books(String bookTitle, String author, boolean genre, GenreCategory genreCat,
                 String date, String comment) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.genreCat = genreCat;
        this.date = date;
        this.comment = comment;

        this.id = count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Books.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isGenre() {
        return genre;
    }

    public void setGenre(boolean genre) {
        this.genre = genre;
    }

    public GenreCategory getGenreCat() {
        return genreCat;
    }

    public void setGenreCat(GenreCategory genreCat) {
        this.genreCat = genreCat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
