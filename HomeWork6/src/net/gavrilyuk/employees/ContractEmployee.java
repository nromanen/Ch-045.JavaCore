package net.gavrilyuk.employees;

/**
 * Contract Employee class
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class ContractEmployee extends BaseEmployee implements PaidWorker {

    private String federalTaxIdMember;
    private TariffRates hourlyRate;
    private int hoursWorked;
    private Department department;

    public ContractEmployee(String name, Department department, String federalTaxIdMember, TariffRates hourlyRate, int hoursWorked ) {
        super(name);
        this.federalTaxIdMember = federalTaxIdMember;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.department = department;
    }

    public ContractEmployee(String name, Department department,  TariffRates hourlyRate, int hoursWorked) {
        this(name, department, NO_TAX_OR_SOCIAL, hourlyRate, hoursWorked);
    }

    public ContractEmployee(String name, Department department, TariffRates hourlyRate) {
        this(name, department, NO_TAX_OR_SOCIAL, hourlyRate, WORK_HOURLY_PER_MONTH);
    }
    public ContractEmployee(String name, Department department) {
        this(name, department, NO_TAX_OR_SOCIAL, TariffRates.FIRST_RATE, WORK_HOURLY_PER_MONTH);
    }


    public ContractEmployee(String name) {
        this(name, Department.MANAGE, NO_TAX_OR_SOCIAL, TariffRates.FIRST_RATE, WORK_HOURLY_PER_MONTH);
    }


    public String getFederalTaxIdMember() {
        return federalTaxIdMember;
    }

    public void setFederalTaxIdMember(String federalTaxIdMember) {
        this.federalTaxIdMember = federalTaxIdMember;
    }

    public TariffRates getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(TariffRates hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public float calculatePay() {
        return hourlyRate.getTariffRateValue() * hoursWorked;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString()+", department="+ department.getDepName() +", average monthly wage="+String.format("%,.2f", calculatePay());
    }
}
