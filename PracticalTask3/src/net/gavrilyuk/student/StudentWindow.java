package net.gavrilyuk.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

/**
 *
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class StudentWindow extends JFrame {


    private JLabel ratingLabel;
    private JButton addButton;
    private JTable studentsTable;
    private StudentAdapter studentAdapter;
    //fields
    private final JTextField nameField;
    private final JTextField ratingField;

    public StudentWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        studentAdapter = new StudentAdapter();//adapter
        studentsTable = new JTable(studentAdapter);//table
        studentsTable.setPreferredScrollableViewportSize(new Dimension(600, 150));
        studentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentAdapter.setData(StudentsDbUtil.readFromDb(StudentsDbUtil.DB_NAME));
        initTablePopupMenu(studentsTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameField);
        editPanel.add(box1);
        Box box2 = Box.createHorizontalBox();
        JLabel rateLabel = new JLabel("Rating:");
        ratingField = new JTextField(6);
        box2.add(rateLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(ratingField);
        editPanel.add(box2);
        addButton = new JButton("Add");//add button
        editPanel.add(addButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(studentsTable);
        contentPanel.add(jscrlp);
        ratingLabel = new JLabel("Average rating:"  );

        initListener();

        contentPanel.add(ratingLabel, BorderLayout.SOUTH);
        //setContentPane(contentPanel);
        getContentPane().add(editPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel);// add to center
        setSize(650, 300);
        updateViews();
    }

    private void initListener() {
        if (addButton != null) {
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try { //magic
                        String name = nameField.getText().trim();
                        if (name.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            if (isAlpha(name)) {
                                name = toCapsWord(name);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }
                        int rating = Integer.parseInt(ratingField.getText().trim());
                        //if valid name and rating - create student object
                        Student student = new Student();
                        student.setName(name);
                        student.setRating(rating);
                        studentAdapter.addStudent(student);
                        studentAdapter.fireTableDataChanged();
                        updateViews();
                    } catch (IllegalArgumentException eArg) {
                        JOptionPane.showMessageDialog(null, eArg.getMessage(), "Invalid value", JOptionPane.WARNING_MESSAGE);
                    }

                }
            });
        }
    }

    private void initTablePopupMenu(JTable table) {
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(StudentWindow.this, "Delete this record?") == JOptionPane.YES_OPTION) {
                int row = studentsTable.getSelectedRow();//selected table row
                if (row != -1) {
                    studentAdapter.removeStudent(row);
                    //todo release update total and average rating after delete record
                    studentAdapter.fireTableDataChanged();
                    updateViews();
                    // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                } else JOptionPane.showMessageDialog(StudentWindow.this, "no row is selected");
            }
        }
    });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void updateViews() {
        if (ratingLabel != null) {
            ratingLabel.setText(String.format("%s%,.2f%s%,.2f", "Average rating: ", studentAdapter.getAvgRating(),
                    " Total rating: ", studentAdapter.getTotalRating()));
        }
        if (nameField !=null) nameField.setText("");
        if (ratingField !=null) ratingField.setText("");
    }

    // util method
    private   String toCapsWord(String s) {
        String result="";
        try { //fix
            if (s != null && s.length()>0) {
                String[] words = s.split("\\s");
                for (String w : words) {
                    if (w.length() > 0) {
                        w = w.trim().replaceFirst(String.valueOf(w.trim().charAt(0)),String.valueOf(Character.toUpperCase(w.trim().charAt(0))))+" ";
                        result+=w;
                    }
                }
            }
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        return  result.trim();

    }

    private   boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }

}
