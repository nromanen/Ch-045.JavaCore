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


    private JLabel totalHoursLabel;
    private JButton addButton;
    private JTable employeeTable;
    private EmployeeAdapter employeeAdapter;
    //input fields
    private final JTextField hoursField;
    private final JTextField nameField;
    private final JTextField rateField;

    public EmployeeWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        employeeAdapter = new EmployeeAdapter();//adapter
        employeeTable = new JTable(employeeAdapter);//table
        employeeTable.setPreferredScrollableViewportSize(new Dimension(600, 150));
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       // employeeAdapter.setData(EmployeeUtil.readFromDb(EmployeeUtil.DB_NAME));
        employeeAdapter.setData(EmployeeLab.get().getEmployees());
        initTablePopupMenu(employeeTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameField);
        editPanel.add(box1);
        Box box2 = Box.createHorizontalBox();
        JLabel rateLabel = new JLabel("Rate:");
        rateField = new JTextField(6);
        box2.add(rateLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(rateField);
        editPanel.add(box2);
        Box box3 = Box.createHorizontalBox();
        JLabel hoursLabel = new JLabel("Hours:");
       // NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
       // DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
       // decimalFormat.setGroupingUsed(false);
       // hoursField = new JFormattedTextField(decimalFormat);
       // hoursField.setColumns(10);
        hoursField = new JTextField(6);
        box3.add(hoursLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(hoursField);
        editPanel.add(box3);
        addButton = new JButton("Add");//add button
        editPanel.add(addButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(employeeTable);
        contentPanel.add(jscrlp);

        initListener();

        contentPanel.add(totalHoursLabel, BorderLayout.SOUTH);
        getContentPane().add(editPanel, BorderLayout.NORTH);
        getContentPane().add(contentPanel);// add to center
        setSize(650, 300);
        updateViews();
    }
    // user enter data in fields and press add button
    private void initListener() {
        if (addButton != null) {
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                     //magic test
                    try {
                        String name = nameField.getText().trim();
                        if (name.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            // if (name.matches("^[a-zA-Z ]*$")) { // not work from other lang
                            if (EmployeeUtil.isAlpha(name)) {
                                name = EmployeeUtil.toCapsWord(name);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }
                        double rate = Double.parseDouble(rateField.getText().trim());
                        int hours = Integer.parseInt(hoursField.getText().trim());

                        Employee employee = new Employee();  //if all fields valid - only to create an object
                        employee.setName(name);
                        employee.setRate(rate);
                        employee.setHours(hours);
                        employeeAdapter.addEmployee(employee);
                        employeeAdapter.fireTableDataChanged();
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
                int row = employeeTable.getSelectedRow();//selected table row
                if (row != -1) {
                    employeeAdapter.removeEmployee(row);
                    // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                } else JOptionPane.showMessageDialog(EmployeeWindow.this, "no row is selected");
            }
        }
    });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void updateViews() {
        if (totalHoursLabel != null) {
            totalHoursLabel.setText( String.format("%s%d", "Total hours:", employeeAdapter.getTotalHours()));
        }
        if (hoursField !=null) hoursField.setText("");
        if (nameField !=null) nameField.setText("");
        if (rateField !=null) rateField.setText("");

    }
}
