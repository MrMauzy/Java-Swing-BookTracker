package gui;

import data.Books;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookInfoModel extends AbstractTableModel {

   private List<Books> db;

   private String[] colNames = {"Title", "Author", "Fiction", "Genre", "Date Read", "Comments"};

   public BookInfoModel() {
   }

   @Override
    public String getColumnName(int column) {return colNames[column];}

    public void setData(List<Books> db) {this.db = db; }

    @Override
    public int getRowCount() { return db.size(); }

    @Override
    public int getColumnCount() { return 6;}

    @Override
    public Object getValueAt(int row, int col) {
       Books books = db.get(row);

       switch(col) {
           case 0:
               return books.getBookTitle();
           case 1:
               return books.getAuthor();
           case 2:
               return books.isGenre();
           case 3:
               return books.getGenreCat();
           case 4:
               return books.getDate();
           case 5:
               return books.getComment();
       }
       return null;
    }

}
