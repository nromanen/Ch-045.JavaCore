package homework5.employees;

/**
 * Created by roma on 16.10.2016.
 */
public enum Department{
    ADMINISTRATOR("Administrator"),
    TEACHER("Teacher"),
    CLEANER("Cleaner"),
    DRIVER("Driver");

    public String department;

    Department(){}

    Department(String department){
        this.department = department;
    }
}

