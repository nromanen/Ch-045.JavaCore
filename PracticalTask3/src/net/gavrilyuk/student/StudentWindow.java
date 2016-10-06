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


    private JLabel mRatingLabel;
    private JButton mAddButton;
    private JTable mStudentsTable;
    private StudentAdapter mStudentAdapter;
    //fields
    private final JTextField mNameField;
    private final JTextField mRatingField;

    public StudentWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mStudentAdapter = new StudentAdapter();//adapter
        mStudentsTable = new JTable(mStudentAdapter);//table
        mStudentsTable.setPreferredScrollableViewportSize(new Dimension(600, 150));
        mStudentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mStudentAdapter.setData(StudentsDbUtil.readFromDb(StudentsDbUtil.DB_NAME));
        initTablePopupMenu(mStudentsTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        mNameField = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(mNameField);
        editPanel.add(box1);
        Box box2 = Box.createHorizontalBox();
        JLabel rateLabel = new JLabel("Rating:");
        mRatingField = new JTextField(6);
        box2.add(rateLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(mRatingField);
        editPanel.add(box2);
        mAddButton = new JButton("Add");//add button
        editPanel.add(mAddButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(mStudentsTable);
        contentPanel.add(jscrlp);
        mRatingLabel = new JLabel("Average rating:"  );

        initListener();

        contentPanel.add(mRatingLabel, BorderLayout.SOUTH);
        //setContentPane(contentPanel);
        getContentPane().add(editPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel);// add to center
        setSize(650, 300);
        updateViews();
    }

    private void initListener() {
        if (mAddButton != null) {
            mAddButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try { //magic
                        String name = mNameField.getText().trim();
                        if (name.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            if (isAlpha(name)) {
                                name = toCapsWord(name);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }
                        int rating = Integer.parseInt(mRatingField.getText().trim());
                        //if valid name and rating - create student object
                        Student student = new Student();
                        student.setName(name);
                        student.setRating(rating);
                        mStudentAdapter.addStudent(student);
                        mStudentAdapter.fireTableDataChanged();
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
                int row = mStudentsTable.getSelectedRow();//selected table row
                if (row != -1) {
                    mStudentAdapter.removeStudent(row);
                    //todo release update total and average rating after delete record
                    mStudentAdapter.fireTableDataChanged();
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
        if (mRatingLabel != null) {
            mRatingLabel.setText( String.format("%s%,.2f%s%,.2f", "Average rating: ", mStudentAdapter.getAvgRating(),
                           " Total rating: ", mStudentAdapter.getTotalRating()));
        }
        if (mNameField!=null) mNameField.setText("");
        if (mRatingField !=null) mRatingField.setText("");
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
