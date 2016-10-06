package net.gavrilyuk.person;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * Created by GipSoft on 05.10.2016.
 */
public class PersonAdapter extends AbstractTableModel {
    private final static int COLUMN_COUNT = 3;

    private ArrayList<Person> mPersons;

    public PersonAdapter() {
        mPersons = new ArrayList<>();//create empty
    }

    public ArrayList<Person> getData() {
        return mPersons;
    }


    public void setData(ArrayList<Person> persons) {
        if (persons != null) {
            mPersons = persons;
            fireTableDataChanged();
        }

    }

    public void addPerson(Person person) {
        if (person != null) {
            PersonLab.getInstance().addPerson(person);
            fireTableDataChanged();
        }
    }

    public void removePerson(int index) {
        PersonLab.getInstance().removePerson(index);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return mPersons != null ? mPersons.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return mPersons.get(r).getName();
            case 1:
                return new SimpleDateFormat("dd.MM.yyyy ").format(mPersons.get(r).getBirthDay()) ;
            case 2:
                return mPersons.get(r).age();
            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return Person.JSON_NAME;
            case 1:
                return Person.JSON_BIRTH_DAY;
            case 2:
                return "Age";
            default:
                return "Invalid Column";
        }
    }



}
