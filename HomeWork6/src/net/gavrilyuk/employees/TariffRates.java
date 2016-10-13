package net.gavrilyuk.employees;

/**
 *  Tariff Rates Enum from salaried employee
 *  Created by Igor Gavryliuk on 12.10.2016.
 */
public enum TariffRates {
    TARIFF_1( "Tariff 1", 5000),
    TARIFF_2( "Tariff 2", 7000),
    TARIFF_3( "Tariff 3", 9000);

    private String tariffName;
    private float tariffValue;

    TariffRates( String tariffName, float tariffValue) {
        this.tariffName = tariffName;
        this.tariffValue = tariffValue;
    }


    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) throws IllegalArgumentException {
       if(tariffName == null || tariffName.trim().isEmpty()){
           throw new IllegalArgumentException("Tariff name should not be empty!");
         }
       this.tariffName = tariffName;
    }

    public float getTariffValue() {
        return tariffValue;
    }

    public void setTariffValue(float tariffValue) throws IllegalArgumentException {
            if (tariffValue < 0) // need?
                throw new IllegalArgumentException("Tariff cannot be negative.");
            this.tariffValue = tariffValue;

    }
}
