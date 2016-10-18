package inheritance.homework.employee;

// Employees whit fixed salary
public class SalariedEmployee extends Employee implements Payment{

    private int socialSecurityNumber;
    private int salaryCoeffitient = 50;

    public SalariedEmployee(String name, Category category, int socialSecurityNumber) {
        super(name, category);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public double calculatePay() {
        return this.salaryCoeffitient * EmployeeService.getRate(this);
    }
}
