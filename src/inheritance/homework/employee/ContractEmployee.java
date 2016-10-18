package inheritance.homework.employee;

// Contract employees whit hour salary
public class ContractEmployee extends Employee{

    private int federalTaxIdNumber;
    private int hours;

    public ContractEmployee(String name, Category category, int federalTaxIdNumber, int hours) {
        super(name, category);
        this.federalTaxIdNumber = federalTaxIdNumber;
        this.hours = hours;
    }

    @Override
    public double calculatePay() {
        return hours * EmployeeService.getRate(this);
    }
}
