package net.gavrilyuk.countries_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class CountriesWindow extends JFrame {



    private JTable mCountriesTable;
    private CountriesModel mCountriesAdapter;


    public CountriesWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mCountriesAdapter = new CountriesModel();//adapter
        mCountriesTable = new JTable(mCountriesAdapter);//table
        //sort
        mCountriesTable.setAutoCreateRowSorter(true);
        DefaultRowSorter sorter = ((DefaultRowSorter)mCountriesTable.getRowSorter());
        //TableRowSorter sorter = new TableRowSorter<>(mCountriesAdapter);
        ArrayList<RowSorter.SortKey> list = new ArrayList<>();
        list.add( new RowSorter.SortKey(2, SortOrder.ASCENDING) );
        list.add( new RowSorter.SortKey(3, SortOrder.ASCENDING) );
        list.add( new RowSorter.SortKey(4, SortOrder.ASCENDING) );
        sorter.setSortKeys(list);
        //sorter.sort();
        mCountriesTable.setRowSorter(sorter);




        mCountriesTable.setRowHeight(92); // set rows height
        mCountriesTable.getColumnModel().getColumn(0).setPreferredWidth(10); // set col  num with
        mCountriesTable.getColumnModel().getColumn(1).setMinWidth(140); // set col flag with
        mCountriesTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());//set image render
        mCountriesTable.setPreferredScrollableViewportSize(new Dimension(960, 760));
        mCountriesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mCountriesAdapter.setData(CountriesLab.get().getCountries());
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        JScrollPane jscrlp = new JScrollPane(mCountriesTable);
        contentPanel.add(jscrlp);
        getContentPane().add(contentPanel);// add to center
        setSize(1000, 800);
       // updateViews();
    }

    private void initTablePopupMenu(JTable table) {
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(CountriesWindow.this, "Delete this record?") == JOptionPane.YES_OPTION) {
                int row = mCountriesTable.getSelectedRow();//selected table row
                if (row != -1) {
                    mCountriesAdapter.removeCountry(row);
                    // JOptionPane.showMessageDialog(StudentWindow.this, " selected row=" + row);
                } else JOptionPane.showMessageDialog(CountriesWindow.this, "no row is selected");
            }
        }
    });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }


}
