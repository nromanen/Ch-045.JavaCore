package net.gavrilyuk.employees;

import java.util.UUID;

/**
 * Employee class
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public  class BaseEmployee  {

    private final UUID employeeId;//unique id
    private String name;// employee name
    public BaseEmployee() {
        this("");
    }

    public BaseEmployee(String name) {
        employeeId = UUID.randomUUID();
        this.name = name;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return  "EmployeeId=" + employeeId + ", Name='" + name + '\'';
    }
}
