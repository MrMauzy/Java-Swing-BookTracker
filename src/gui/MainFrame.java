package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private FormPanel formPanel;
    private TablePanel tablePanel;
    private Controller controller;

    public MainFrame() {
        super("Adventure List");

        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getBooks());

        formPanel.setFormListener( new FormListener() {
            public void formEventOccured(FormEvent e) {
                controller.addBooks(e);
                tablePanel.refresh();
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(1000, 700));
        setSize(1300, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
