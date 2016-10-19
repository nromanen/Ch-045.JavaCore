package Employee;

/**
 * Created by evil on 18.10.16.
 */
public class SalariedEmployee extends Employee implements Salary {
    private int averageMonthlySalary;
    private int fixedPayment;
    public SalariedEmployee(){
        super();
    }

    public SalariedEmployee(String name){
        super(name);
    }
    @Override
    public void calculatePay() {
        averageMonthlySalary = fixedPayment;
    }

    public int getAverageMonthlySalary() {
        calculatePay();
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(int averageMonthlySalary) {
        this.averageMonthlySalary = averageMonthlySalary;
    }

    public int getFixedPayment() {
        return fixedPayment;
    }

    public void setFixedPayment(int fixedPayment) {
        this.fixedPayment = fixedPayment;
    }

    public void printInf(){
        System.out.println("Name: " + getName()
                            + " id: " + getId()
                            + " average salary: " + getAverageMonthlySalary());
    }
}
