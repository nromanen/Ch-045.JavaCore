package net.gavrilyuk.person;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 *
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class PersonWindow extends JFrame {

    private JButton mAddButton;
    private JTable mPersonTable;
    private PersonAdapter mPersonAdapter;
    //input fields
    private final JTextField mNameField;
    //private final JTextField mDateField;
    private JDatePickerImpl datePicker;

    public PersonWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mPersonAdapter = new PersonAdapter();//adapter
        mPersonTable = new JTable(mPersonAdapter);//table
        mPersonTable.setPreferredScrollableViewportSize(new Dimension(600, 150));
        mPersonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // mPersonAdapter.setData(EmployeeUtil.readFromDb(EmployeeUtil.DB_NAME));
        mPersonAdapter.setData(PersonLab.getInstance().getPersons());
        initTablePopupMenu(mPersonTable);//popup menu from delete item
        JPanel editPanel = new JPanel();
        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        mNameField = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(mNameField);
        editPanel.add(box1);
        Box box2 = Box.createHorizontalBox();
        JLabel rateLabel = new JLabel("Birth Day:");
        UtilDateModel model = new UtilDateModel();
        model.setDate(2016, 10, 6);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //mDateField = new JTextField(6);
        box2.add(rateLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(datePicker);
        editPanel.add(box2);
        mAddButton = new JButton("Add");//add button
        editPanel.add(mAddButton);

        JPanel contentPanel = new JPanel();

        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(mPersonTable);
        contentPanel.add(jscrlp);
        initListener();
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
                    try {
                        String name = mNameField.getText().trim();
                        if (name.isEmpty()) { //first - check name
                            throw new IllegalArgumentException("The name must not be empty!");
                        } else {
                            if (PersonUtil.isAlpha(name)) {
                                name = PersonUtil.toCapsName(name);
                            } else throw new IllegalArgumentException("The name can not contain numbers!");
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                        //Date date = formatter.parse(mDateField.getText().trim());
                        Date date = (Date) datePicker.getModel().getValue();
                        Person person = new Person();  //if all fields valid - only to create an object
                        person.setName(name);
                        person.setBirthDay(date);
                        mPersonAdapter.addPerson(person);
                        mPersonAdapter.fireTableDataChanged();
                        updateViews();
                    } catch (IllegalArgumentException ea) {
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
                if (JOptionPane.showConfirmDialog(PersonWindow.this, "Delete this record?") == JOptionPane.YES_OPTION) {
                    int row = mPersonTable.getSelectedRow();//selected table row
                    if (row != -1) {
                        mPersonAdapter.removePerson(row);
                        // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                    } else JOptionPane.showMessageDialog(PersonWindow.this, "no row is selected");
                }
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void updateViews() {
        if (mNameField!=null) mNameField.setText("");
        //if (mDateField !=null) mDateField.setText("");

    }
}
