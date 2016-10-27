package database;


import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

    private String firstName;
    private String lastName;
    private GregorianCalendar birthDay;
    private final int SSN;
    private double rate = 150.0;
    private Position position = Position.TRAINEE;

    public Employee(String firstName, String lastName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = EmployeeService.getSSN();

        this.birthDay = new GregorianCalendar(year, (month-1), day);
    }

    public Employee(String firstName, String lastName, int year, int month, int day, Position position) {
        this(firstName, lastName, year, month, day);
        this.position = position;
    }

    public Employee(String firstName, String lastName, int year, int month, int day, Position position, double rate) {
        this(firstName, lastName, year, month, day, position);
        this.rate = rate;
    }

    public int getSSN() {
        return SSN;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GregorianCalendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(GregorianCalendar birthDay) {
        this.birthDay = birthDay;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAge(){

        return (int)((new Date().getTime() - birthDay.getTimeInMillis())/31536000000L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getSSN() != employee.getSSN()) return false;
        if (Double.compare(employee.getRate(), getRate()) != 0) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        if (getBirthDay() != null ? !getBirthDay().equals(employee.getBirthDay()) : employee.getBirthDay() != null)
            return false;
        return getPosition() == employee.getPosition();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getBirthDay() != null ? getBirthDay().hashCode() : 0);
        result = 31 * result + getSSN();
        temp = Double.doubleToLongBits(getRate());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        return result;
    }
}
