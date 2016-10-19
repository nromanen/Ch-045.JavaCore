package Employee;

/**
 * Created by evil on 18.10.16.
 */
public class ContractEmployee extends Employee implements Salary {
    private int averageMonthlySalary;
    private int rateHours;
    private int workedHours;

    public ContractEmployee(){
        super();
    }
    public ContractEmployee(String name){
        super(name);
    }

    @Override
    public void calculatePay() {
        averageMonthlySalary = rateHours * workedHours;
    }

    public int getAverageMonthlySalary() {
        calculatePay();
        return averageMonthlySalary;
    }

    public void setAverageMonthlySalary(int averageMonthlySalary) {
        this.averageMonthlySalary = averageMonthlySalary;
    }

    public int getRateHours() {
        return rateHours;
    }

    public void setRateHours(int rateHours) {
        this.rateHours = rateHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public void printInf(){
        System.out.println("Name: " + getName()
                            + " id: " + getId()
                            + " average salary: " + getAverageMonthlySalary());
    }
}
