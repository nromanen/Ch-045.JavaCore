package homework5.employees;

/**
 * Created by roma on 13.10.2016.
 */
public enum SalaryType {
    JUNIOR(4000),
    MIDDLE(6000),
    SENIOR(8000);

    public int salary;

    SalaryType(int salary) {
        this.salary = salary;
    }
}
