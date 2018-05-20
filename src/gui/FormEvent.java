package gui;

import java.util.EventObject;

public class FormEvent extends EventObject{

    public String bookTitle;
    public String author;
    public boolean genre;
    public String genreCat;
    public String date;
    public String comment;

    public FormEvent (Object source) {super(source); }

    public FormEvent (Object source, String bookTitle, String author, boolean genre, String genreCat,
                      String date, String comment) {
        super(source);

        this.bookTitle = bookTitle;
        this.author = author;

        this.genre = genre;
        this.genreCat = genreCat;
        this.date = date;
        this.comment = comment;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenreCat() {return genreCat; }
}
