package net.gavrilyuk.employee;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class NewEmployee {

    private String name; //name
    private int depNumber; // department number
    private float salary;


    public NewEmployee(String name, int depNumber, float salary) {
        this.name = name;
        this.depNumber = depNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(int depNumber) {
        this.depNumber = depNumber;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + name + '\'' +
                ", DepNumber=" + depNumber +
                ", Salary=" + salary +
                '}';
    }
}
