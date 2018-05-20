package data;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataBase {

    private List<Books> bookLists;

    public DataBase() { bookLists = new LinkedList<Books>(); }

    public void addBooks(Books books) { bookLists.add(books);}

    public List<Books> getBooks() {
        return Collections.unmodifiableList(bookLists);
    }
}
