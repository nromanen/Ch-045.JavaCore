package loopsandarrays.practice.employee;


public class Employee{

    private String name;
    private int departmentNum;
    private int salary;

    {
        Company.allEmployee.add(this);
    }

    public Employee(String name, int departmentNum,  int salary) {
        this.departmentNum = departmentNum;
        this.name = name;
        this.salary = salary;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(int departmentNum) {
        this.departmentNum = departmentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getDepartmentNum() != employee.getDepartmentNum()) return false;
        if (getSalary() != employee.getSalary()) return false;
        return !(getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getDepartmentNum();
        result = 31 * result + getSalary();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " name: " + name +
                ", department: " + departmentNum  +
                ", salary: " + salary +
                '}';
    }
}
