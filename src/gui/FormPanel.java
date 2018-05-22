package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPanel extends JPanel{

    private JLabel authorLabel;
    private JTextField authorField;
    private JLabel titleLabel;
    private JTextField titleField;
    private JRadioButton fictRadio;
    private JRadioButton nonfictRadio;
    private ButtonGroup genreGroup;
    private JComboBox genreCombo;
    private JFormattedTextField dateField;
    private JLabel dateLabel;
    private JButton submitBtn;
    private JLabel title;
    private JTextArea commentArea;
    private JLabel commentLabel;
    private FormListener formListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 500;
        setPreferredSize(dim);


        // Text Field Setup
        authorLabel = new JLabel("Author's Name: ");
        authorField = new JTextField(25);
        titleLabel = new JLabel("Books Title: ");
        titleField = new JTextField(25);
        dateLabel = new JLabel("Date Read: ");
        title = new JLabel("Enter Your Adventure Information Below");
        commentArea = new JTextArea(5, 20);
        commentLabel = new JLabel("Comments: ");

        //Radio Buttons
        fictRadio = new JRadioButton("Fiction");

        nonfictRadio = new JRadioButton("Non-Fiction");
        genreGroup = new ButtonGroup();
        fictRadio.setActionCommand("fiction");
        nonfictRadio.setActionCommand("nonfiction");
        genreGroup.add(fictRadio);
        genreGroup.add(nonfictRadio);

        //Combo Boxes
        genreCombo = new JComboBox();
        DefaultComboBoxModel genreModel = new DefaultComboBoxModel();
        genreCombo.setModel(genreModel);
        genreCombo.setPrototypeDisplayValue("XXXXXXXXXXXXXXX");

        fictRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    genreModel.removeAllElements();
                    genreModel.addElement("Comic");
                    genreModel.addElement("Fantasy");
                    genreModel.addElement("Science-Fiction");
                    genreModel.addElement("Young-Adult");
                }
                else {
                    genreModel.removeAllElements();
                    genreModel.addElement("Biography");
                    genreModel.addElement("Business");
                    genreModel.addElement("Money");
                    genreModel.addElement("Religion");
                    genreModel.addElement("Science");
                }

            }
        });

        fictRadio.setSelected(true);

        dateField = new JFormattedTextField("MM/DD/YYYY");
        dateField.setColumns(10);

        //Label Setting
        authorLabel.setLabelFor(authorField);
        titleLabel.setLabelFor(titleField);
        dateLabel.setLabelFor(dateField);
        commentLabel.setLabelFor(commentArea);

        submitBtn = new JButton("Submit");
        submitBtn.setMnemonic(KeyEvent.VK_S);

        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                boolean genre = fictRadio.isSelected();
                String genreCat = (String) genreModel.getSelectedItem();
                String date = dateField.getText();
                if(date != null) {
                    Date dateCheck = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
                        dateCheck = sdf.parse(date);
                        if(!date.equals(sdf.format(dateCheck))) {
                            dateCheck = null;
                        }
                    } catch (ParseException e1) {
                        JOptionPane.showMessageDialog(FormPanel.this,
                                "Not a Valid Date", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(dateCheck == null) {
                        JOptionPane.showMessageDialog(FormPanel.this,
                                "Invalid Date Format Given", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                String comment = commentArea.getText();

                FormEvent ev = new FormEvent(this, title, author, genre, genreCat, date, comment);

                if(formListener != null) {
                    formListener.formEventOccured(ev);
                }
            }
        });

        layoutComponents();
    }
    public void setFormListener(FormListener listener) {this.formListener = listener;}

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///////// Title Row////////////

        gc.gridy = 0;
        gc.gridx = 1;
        gc.weightx = 0;
        gc.weighty = 1.0;

        gc.anchor = GridBagConstraints.WEST;
        Font font = new Font("Verdana", Font.BOLD, 16);
        title.setFont(font);
        add(title, gc);


        ///////// First Row////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(titleLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(titleField, gc);

        ///////// Second Row////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(authorLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(authorField, gc);

        /////////////Third Row //////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.0;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Is This Book: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(fictRadio, gc);

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(nonfictRadio, gc);

        /////////////Forth Row //////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.02;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Genre: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(genreCombo, gc);

        /////////////Fifth Row //////////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_END;
        add(dateLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(dateField, gc);

        ///////// Second Row////////////

        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(commentLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(new JScrollPane(commentArea), gc);

        /////////////Last Row //////////////////

        gc.gridy++;
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1.0;
        gc.ipady = 5;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitBtn, gc);
    }
}
