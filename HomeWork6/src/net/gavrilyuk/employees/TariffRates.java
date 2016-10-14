package net.gavrilyuk.employees;

/**
 *  Tariff Rates Enum from salaried and contract employees
 *  Created by Igor Gavryliuk on 12.10.2016.
 */
public enum TariffRates {

    TARIFF_1( "Tariff 1", 5000),
    TARIFF_2( "Tariff 2", 7000),
    TARIFF_3( "Tariff 3", 9000),
    FIRST_RATE("Hourly Rate1", 10),
    SECOND_RATE("Hourly Rate2", 15),
    THIRD_RATE("Hourly Rate3", 20);

    private String tariffRateName;
    private float tariffRateValue;

    TariffRates( String tariffName, float tariffValue) {
        this.tariffRateName = tariffName;
        this.tariffRateValue = tariffValue;
    }


    public String getTariffRateName() {
        return tariffRateName;
    }

    public void setTariffRateName(String tariffRateName) throws IllegalArgumentException {
       if(tariffRateName == null || tariffRateName.trim().isEmpty()){
           throw new IllegalArgumentException("Tariff or rate name should not be empty!");
         }
       this.tariffRateName = tariffRateName;
    }

    public float getTariffRateValue() {
        return tariffRateValue;
    }

    public void setTariffRateValue(float tariffRateValue) throws IllegalArgumentException {
            if (tariffRateValue < 0) // need?
                throw new IllegalArgumentException("Tariff or rate cannot be negative.");
            this.tariffRateValue = tariffRateValue;

    }
}
