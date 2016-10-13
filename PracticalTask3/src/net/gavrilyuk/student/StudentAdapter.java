package net.gavrilyuk.student;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Student Adapter from JTable
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class StudentAdapter extends AbstractTableModel {

    private final static int COLUMN_COUNT = 2;
    private final static String COLUMN_NAME = "Name";
    private final static String COLUMN_RATING = "Rating";

    private List<Student> students;

    public StudentAdapter() {
        students = new ArrayList<>();//create empty
    }

    public List<Student> getData() {
        return students;
    }

    public void setData(List<Student> students) {
        if (students != null) {
            this.students = students;
            fireTableDataChanged();
        }

    }

    public void addStudent(Student student) {
        if (students != null) {
            if (StudentsDbUtil.addToDb(student) == StudentsDbUtil.DB_TRANSACTION_OK) {
                students.add(student);
                fireTableDataChanged();
            }
        }
    }

    public void removeStudent(int index) {
        if (students != null) {
            if (StudentsDbUtil.removeOfDb(index) == StudentsDbUtil.DB_TRANSACTION_OK) {
                students.remove(index);
                fireTableDataChanged();
            }
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
                return students.get(r).getName();
            case 1:
                return students.get(r).getRating();
            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return COLUMN_NAME;
            case 1:
                return COLUMN_RATING;
            default:
                return "Other Column";
        }
    }

    public double getAvgRating() {
        return Student.getAvgRating();
    }

    public double getTotalRating() {
        return Student.getTotalRating();
    }

}
