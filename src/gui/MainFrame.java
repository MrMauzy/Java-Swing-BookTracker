package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame{

    private FormPanel formPanel;
    private TablePanel tablePanel;
    private Controller controller;
    private JFileChooser fileChooser;

    public MainFrame() {
        super("Adventure List");

        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getBooks());

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new BookFileFilter());

        setJMenuBar(createMenuBar());

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

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportData = new JMenuItem("Export Book List");
        JMenuItem importData = new JMenuItem(("Import Book List"));
        JMenuItem exitProgram = new JMenuItem("Exit");

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.addSeparator();
        fileMenu.add(exitProgram);

        menuBar.add(fileMenu);

        // Sets shortcuts to key menu items
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exportData.setMnemonic(KeyEvent.VK_E);
        importData.setMnemonic(KeyEvent.VK_I);
        exitProgram.setMnemonic(KeyEvent.VK_X);

        //Fast track to exit the program with CTRL+X
        exitProgram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        exportData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException el) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could Not Save Book List",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        importData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanel.refresh();
                    } catch (IOException el) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could Not Load Selected Book File",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        exitProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return menuBar;
    }
}
