package Employee;

import java.util.*;

/**
 * Created by evil on 18.10.16.
 */
public abstract class Employee {
    private static int countEmployee = 0;
    private int id;
    private String name;

    public Employee(){
        this.id = ++countEmployee;
    }

    public Employee(String name){
        this.id = ++countEmployee;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCountEmployee() {
        return countEmployee;
    }

    public abstract int getAverageMonthlySalary();
    public abstract void printInf();
}
