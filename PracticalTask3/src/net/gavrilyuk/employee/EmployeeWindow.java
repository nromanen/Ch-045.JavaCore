package net.gavrilyuk.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class EmployeeWindow extends JFrame {


    private JLabel mTotalHoursLabel;
    private JButton mAddButton;
    private JTable mEmployeeTable;
    private EmployeeAdapter mEmployeeAdapter;
    //input fields
    private final JTextField mHoursField;
    private final JTextField mNameField;
    private final JTextField mRateField;

    public EmployeeWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mEmployeeAdapter = new EmployeeAdapter();//adapter
        mEmployeeTable = new JTable(mEmployeeAdapter);//table
        mEmployeeTable.setPreferredScrollableViewportSize(new Dimension(600, 150));
        mEmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       // mEmployeeAdapter.setData(EmployeeUtil.readFromDb(EmployeeUtil.DB_NAME));
        mEmployeeAdapter.setData(EmployeeLab.get().getEmployees());
        initTablePopupMenu(mEmployeeTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        mNameField = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(mNameField);
        editPanel.add(box1);
        Box box2 = Box.createHorizontalBox();
        JLabel rateLabel = new JLabel("Rate:");
        mRateField = new JTextField(6);
        box2.add(rateLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(mRateField);
        editPanel.add(box2);
        Box box3 = Box.createHorizontalBox();
        JLabel hoursLabel = new JLabel("Hours:");
       // NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
       // DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
       // decimalFormat.setGroupingUsed(false);
       // mHoursField = new JFormattedTextField(decimalFormat);
       // mHoursField.setColumns(10);
        mHoursField = new JTextField(6);
        box3.add(hoursLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(mHoursField);
        editPanel.add(box3);
        mAddButton = new JButton("Add");//add button
        editPanel.add(mAddButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(mEmployeeTable);
        contentPanel.add(jscrlp);

        initListener();

        contentPanel.add(mTotalHoursLabel, BorderLayout.SOUTH);
        getContentPane().add(editPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel);// add to center
        setSize(650, 300);
        updateViews();
    }
    // user enter data in fields and press add button
    private void initListener() {
        if (mAddButton != null) {
            mAddButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                     //magic test
                    try {
                        String name = mNameField.getText().trim();
                        if (name.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            // if (name.matches("^[a-zA-Z ]*$")) { // not work from other lang
                            if (EmployeeUtil.isAlpha(name)) {
                                name = EmployeeUtil.toCapsWord(name);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }
                        double rate = Double.parseDouble(mRateField.getText().trim());
                        int hours = Integer.parseInt(mHoursField.getText().trim());

                        Employee employee = new Employee();  //if all fields valid - only to create an object
                        employee.setName(name);
                        employee.setRate(rate);
                        employee.setHours(hours);
                        mEmployeeAdapter.addEmployee(employee);
                        mEmployeeAdapter.fireTableDataChanged();
                        updateViews();
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Invalid value", JOptionPane.WARNING_MESSAGE);
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
                if (JOptionPane.showConfirmDialog(EmployeeWindow.this, "Delete this record?") == JOptionPane.YES_OPTION) {
                int row = mEmployeeTable.getSelectedRow();//selected table row
                if (row != -1) {
                    mEmployeeAdapter.removeEmployee(row);
                    // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                } else JOptionPane.showMessageDialog(EmployeeWindow.this, "no row is selected");
            }
        }
    });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void updateViews() {
        if (mTotalHoursLabel != null) {
            mTotalHoursLabel.setText( String.format("%s%d","Total hours:" , mEmployeeAdapter.getTotalHours()));
        }
        if (mHoursField!=null) mHoursField.setText("");
        if (mNameField!=null) mNameField.setText("");
        if (mRateField !=null) mRateField.setText("");

    }
}
