package gui;

import data.Books;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {

    private JTable table;
    private BookInfoModel tableModel;


    public TablePanel() {

        tableModel = new BookInfoModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Books>db) {tableModel.setData(db);}

    public void refresh() {tableModel.fireTableDataChanged();}

}
