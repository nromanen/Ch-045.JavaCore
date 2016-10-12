package classandobject.practice.employee;


import static classandobject.practice.employee.EmploeeService.correctHours;

public class Employee{

    private String name;
    private int rate;
    private int hours;
    private int salary;

    {
        Department.allEmployee.add(this);
    }

    public Employee (){
        this.name = "New Employee";
        this.rate = 0;
        this.hours = 0;

    }

    public Employee(String name, int rate) {
        this.name = name;
        this.rate = rate;
        this.hours = 0;
    }

    public Employee(String name, int rate, int hours) {
        this(name, rate);
        if(correctHours(hours)){
            this.hours = hours;
        } else {
            hours = 160;
        }
        salary = rate * hours;
    }

    // geers and seters
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(correctHours(hours)){
            this.hours = hours;
        } else {
            hours = 160;
        }
        this.salary = this.rate * hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
        this.salary = this.hours * rate;
    }
    public int getSalary(){
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getRate() != employee.getRate()) return false;
        if (getHours() != employee.getHours()) return false;
        return !(getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getRate();
        result = 31 * result + getHours();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name: " + name +
                ", hours: " + hours +
                ", rate: " + rate +
                ", salary: " + salary +
                '}';
    }
}
