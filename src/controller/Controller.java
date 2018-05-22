package controller;


import data.Books;
import data.DataBase;
import data.GenreCategory;
import gui.FormEvent;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    DataBase db = new DataBase();

    public List<Books> getBooks() { return db.getBooks();}

    public void addBooks(FormEvent ev) {
        String bookTitle = ev.getBookTitle();
        String author = ev.getAuthor();
        boolean genre = ev.isGenre();
        String genreCat = ev.getGenreCat();
        String date = ev.getDate();
        String comment = ev.getComment();

        GenreCategory genreCategory;

        if(genreCat.equals("Comic")) {
            genreCategory = GenreCategory.comic;
        }
        else if(genreCat.equals("Fantasy")) {
            genreCategory = GenreCategory.fantasy;
        }
        else if(genreCat.equals("Science-Fiction")) {
            genreCategory = GenreCategory.scienceFiction;
        }
        else if(genreCat.equals("Young-Adult")) {
            genreCategory = GenreCategory.youngAdult;
        }
        else if(genreCat.equals("Biography")) {
            genreCategory = GenreCategory.biography;
        }
        else if(genreCat.equals("Business")) {
            genreCategory = GenreCategory.business;
        }
        else if(genreCat.equals("Money")) {
            genreCategory = GenreCategory.money;
        }
        else if(genreCat.equals("Religion")) {
            genreCategory = GenreCategory.religion;
        }
        else  {
            genreCategory = GenreCategory.science;
        }

        Books books = new Books(bookTitle, author, genre, genreCategory, date, comment);

        db.addBooks(books);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
