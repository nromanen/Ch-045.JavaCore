package net.gavtilyuk.task2;

import java.util.UUID;

/**
 * Employee Class
 * Created by Igor Gavryliuk on 19.10.2016.
 */
public class Employee implements Comparable<Employee> {

    private UUID id;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) throws IllegalArgumentException{
        this.id = UUID.randomUUID();
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException(Employee.class.getSimpleName() + " name can not be empty!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if ( firstName == null|| firstName.isEmpty()) {
            throw new IllegalArgumentException(Employee.class.getSimpleName() + " firstName can not be empty!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if ( lastName == null|| lastName.isEmpty()) {
            throw new IllegalArgumentException(Employee.class.getSimpleName() + " lastName can not be empty!");
        }
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        if (!getFirstName().equals(employee.getFirstName())) return false;
        return getLastName().equals(employee.getLastName());

    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'';
    }


    @Override
    public int compareTo(Employee e) {
        int d = getFirstName().compareTo(e.getFirstName());
        if (d == 0)
            d = getLastName().compareTo(e.getLastName());
        return d;
    }
}
