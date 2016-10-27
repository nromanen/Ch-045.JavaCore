package net.students.adapter;

import net.students.data.SQLContract.StudentsEntry;
import net.students.data.SQLProvider;
import net.students.model.Student;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class StudentsAdapter extends AbstractTableModel {

    private final static int COLUMN_COUNT = 5;

    private ArrayList<Student> students;
    SQLProvider provider;

    public StudentsAdapter() {
        students = new ArrayList<>();//create empty
    }

    public ArrayList<Student> getData() {
        return students;
    }

    public SQLProvider getProvider() {
        return provider;
    }

    public void setProvider(SQLProvider provider) {
        this.provider = provider;
    }

    public void setData(ArrayList<Student> students) {
        if (students != null) {
            this.students = students;
            fireTableDataChanged();
        }

    }

    public void insert(Student student) throws SQLException {
        if (student != null) {
            provider.insertStudent(student);
            fireTableDataChanged();
        }
    }

    public void remove(int id) throws SQLException {
        if (id > 0) {
            provider.removeStudent(id);
            fireTableDataChanged();
        }
    }

    public void update(Student student) throws SQLException {
        if (student != null) {
            provider.updateStudent(student);
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return students != null ? students.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return students.get(r).getFirstName();
            case 1:
                return students.get(r).getLastName();
            case 2:
                return students.get(r).getDateOfBirthdy().toString("yyyy-MM-dd") ;
            case 3:
                return students.get(r).getTestBookNumber();
            case 4:
                return students.get(r).getGroupId();
            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return StudentsEntry.COL_FIRST_NAME;
            case 1:
                return StudentsEntry.COL_LAST_NAME;
            case 2:
                return StudentsEntry.COL_BIRTH_DAY;
            case 3:
                return StudentsEntry.COL_BOOK_NUM;
            case 4:
                return StudentsEntry.COL_GROUP_ID;
            default:
                return "Invalid Column";
        }
    }



}
