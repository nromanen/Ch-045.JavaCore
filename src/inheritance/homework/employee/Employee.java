package inheritance.homework.employee;

public class Employee implements Payment{

    private String name;
    private static int count = 1;
    private int employeeId;
    private Category category;

    public Employee(String name, Category category) {
        this.name = name;
        this.category = category;
        employeeId = count++;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public double calculatePay() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getEmployeeId() != employee.getEmployeeId()) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        return getCategory() == employee.getCategory();

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getEmployeeId();
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  name + ", employeeId: " + employeeId + ", category: " + category + ", salary: " + this.calculatePay();
    }
}
