package net.gavrilyuk.employee;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class Employee {

    private String mName; //name
    private int mDepNumber; // department number
    private float mSalary;


    public Employee(String name, int depNumber, float salary) {
        mName = name;
        mDepNumber = depNumber;
        mSalary = salary;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getDepNumber() {
        return mDepNumber;
    }

    public void setDepNumber(int depNumber) {
        mDepNumber = depNumber;
    }

    public float getSalary() {
        return mSalary;
    }

    public void setSalary(float salary) {
        mSalary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + mName + '\'' +
                ", DepNumber=" + mDepNumber +
                ", Salary=" + mSalary +
                '}';
    }
}
