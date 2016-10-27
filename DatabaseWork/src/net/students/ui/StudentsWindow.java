package net.students.ui;

import javafx.scene.control.ComboBox;
import net.students.adapter.StudentsAdapter;
import net.students.data.SQLProvider;
import net.students.model.Student;
import net.students.util.DateLabelFormatter;
import net.students.util.Utils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class StudentsWindow extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(StudentsWindow.class.getName());


    private JButton insertButton;
    private JTable contentTable;
    private StudentsAdapter contentAdapter;
    //input fields
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField testNumberField;
    private JDatePickerImpl datePicker;
    private SQLProvider contentProvider = null;



    public StudentsWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentAdapter = new StudentsAdapter();//adapter
        contentTable = new JTable(contentAdapter);//table
        contentTable.setPreferredScrollableViewportSize(new Dimension(900, 250));
        contentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // contentAdapter.setData(EmployeeUtil.readFromDb(EmployeeUtil.DB_NAME));

        initSQLDatabase();

        initTablePopupMenu(contentTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(10);
        box1.add(firstNameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(firstNameField);
        editPanel.add(box1);
        Box box3 = Box.createHorizontalBox();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(12);
        box3.add(lastNameLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(lastNameField);
        editPanel.add(box3);

        Box box4 = Box.createHorizontalBox();
        JLabel testNumberLabel = new JLabel("Test Number:");
        testNumberField = new JTextField(8);
        box4.add(testNumberLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(testNumberField);
        editPanel.add(box4);

        Box box5 = Box.createHorizontalBox();
        JLabel selectGroupLabel = new JLabel("Groups:");
        box5.add(selectGroupLabel);
        box5.add(Box.createHorizontalStrut(6));
        final JComboBox groupsComboBox = new JComboBox();
        groupsComboBox.addItem("group1");
        groupsComboBox.addItem("group2");
        groupsComboBox.addItem("group3");
        groupsComboBox.addItem("group4");
        groupsComboBox.addItem("group5");
        box5.add(groupsComboBox);
        editPanel.add(box5);
        Box box2 = Box.createHorizontalBox();
        JLabel birthDayLabel = new JLabel("Birth Day:");
        UtilDateModel model = new UtilDateModel();
        model.setDate(1996, 10, 6);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        box2.add(birthDayLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(datePicker);
        editPanel.add(box2);
        insertButton = new JButton("Add");//add button
        editPanel.add(insertButton);

        JPanel contentPanel = new JPanel();

        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(contentTable);
        contentPanel.add(jscrlp);
        initListener();
        getContentPane().add(editPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel);// add to center
        setSize(950, 500);
        addWindowListener(exitListener);
        updateViews();
    }
    // user enter data in fields and press add button
    private void initListener() {
        if (insertButton != null) {
            insertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        String firstName = firstNameField.getText().trim();
                        String lastName = lastNameField.getText().trim();
                        int  testNumber = Integer.parseInt(testNumberField.getText().trim());
                        if (firstName.isEmpty()|| lastName.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            if (Utils.isAlpha(firstName)&& Utils.isAlpha(lastName) ) {
                                firstName = Utils.toCapsName(firstName);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }

                        DateTime date = //DateTime.parse(datePicker.getModel().getValue().toString());
                        new DateTime(datePicker.getModel().getValue());
                        Student student = new Student();  //if all fields valid - only to create an object
                        student.setFirstName(firstName);
                        student.setLastName(lastName);
                        student.setDateOfBirthdy(date);
                        student.setTestBookNumber(testNumber);
                        student.setGroupId(2);
                        contentAdapter.insert(student);
                        contentAdapter.fireTableDataChanged();
                        updateViews();
                    }catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "SQLException", JOptionPane.WARNING_MESSAGE);
                    }
                    catch (IllegalArgumentException ea) {
                        JOptionPane.showMessageDialog(null, ea.getMessage(), "Invalid value", JOptionPane.WARNING_MESSAGE);
                    } /*catch (ParseException ep) {
                        JOptionPane.showMessageDialog(null, ep.getMessage(), "Invalid date format", JOptionPane.WARNING_MESSAGE);
                    }*/

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
                if (JOptionPane.showConfirmDialog(StudentsWindow.this, "Delete this record?") == JOptionPane.YES_OPTION) {
                    int row = contentTable.getSelectedRow();//selected table row
                    if (row != -1) {
                        try {
                            contentAdapter.remove(row);
                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "SQLException", JOptionPane.WARNING_MESSAGE);
                        }
                        // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                    } else JOptionPane.showMessageDialog(StudentsWindow.this, "no row is selected");
                }
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void updateViews() {
        if (firstNameField !=null) firstNameField.setText("");
        if (lastNameField !=null) lastNameField.setText("");
    }

    private void initSQLDatabase() {

        try {
            //contentProvider = SQLContentProvider.getInstance();
            contentProvider = SQLProvider.getInstance();
            contentAdapter.setProvider(contentProvider);

            // ArrayList<Student> students =contentProvider.query("student", null, " id=? or id=?", new String[]{"2","3"}, null);
            ArrayList<Student> students =contentProvider.getStudents(false);

            contentAdapter.setData(students);
        } catch (ClassNotFoundException cnf) {
            //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, "Driver not found", "Warning", JOptionPane.WARNING_MESSAGE);
            LOGGER.warning("Driver not found");
        } catch (Exception e) {
            //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        LOGGER.info("Goodbye!");
    }//end main

    WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(StudentsWindow.this,
                    "Are You Sure to Close this Application?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
                //finally block used to close resources
                try {
                    if (contentProvider != null) {

                        if (contentProvider.getSqlOpenHelper().getStatement() != null){
                            System.out.println("Close connections!");
                            contentProvider.getSqlOpenHelper().getConnection().close();
                        }

                    }
                } catch (SQLException ignored) {
                }// do nothing
                try {
                    if (contentProvider != null) {
                        if (contentProvider.getSqlOpenHelper().getConnection() != null){
                            System.out.println("Close connections!");
                            contentProvider.getSqlOpenHelper().getConnection().close();
                        }

                    }
                } catch (SQLException se) {
                    JOptionPane.showMessageDialog(null, se.getMessage(), "SQLException", JOptionPane.WARNING_MESSAGE);
                    se.printStackTrace();
                }//end finally try
                System.exit(0);
            }
        }
    };






}
