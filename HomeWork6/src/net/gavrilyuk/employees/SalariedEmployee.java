package net.gavrilyuk.employees;

/**
 * Salaried Employee class
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class SalariedEmployee extends BaseEmployee implements PaidWorker {

    private String socialSecurityNumber;
    private TariffRates fixedRateId;


    public SalariedEmployee(String name, String socialSecurityNumber, TariffRates fixedRateId) {
        super(name);
        this.socialSecurityNumber = socialSecurityNumber;
        this.fixedRateId = fixedRateId;
    }

    public SalariedEmployee(String name,  TariffRates fixedRateId) {
        this(name,NO_TAX_OR_SOCIAL,fixedRateId);
    }

    public SalariedEmployee(String name) {
        this(name, NO_TAX_OR_SOCIAL, TariffRates.TARIFF_1);// default fixed tariff 1, empty socialSecurityNumber
    }



    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public TariffRates getFixedRateId() {
        return fixedRateId;
    }

    public void setFixedRateId(TariffRates fixedRateId) {
        this.fixedRateId = fixedRateId;
    }

    @Override
    public float calculatePay() {
        return fixedRateId.getTariffRateValue();
    }

    @Override
    public Department getDepartment() {
         return Department.SALARIED;
    }

    @Override
    public String toString() {
        return super.toString()+", department="+ Department.SALARIED.getDepName() +", average monthly wage="+ String.format("%,.2f",calculatePay());
    }


}
