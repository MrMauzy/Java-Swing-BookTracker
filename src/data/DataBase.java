package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    // Serialization of data, functions to save and load files
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Books[] records = bookLists.toArray(new Books[bookLists.size()]);

        oos.writeObject(records);

        oos.close();
    }
}
