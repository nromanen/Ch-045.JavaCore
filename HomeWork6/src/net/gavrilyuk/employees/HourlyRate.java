package net.gavrilyuk.employees;

/**
 * Hourly Rate enum from contract employee
 * Created by Igor Gavryliuk on 12.10.2016.
 */
public enum HourlyRate {

    FIRST_RATE("Hourly Rate1", 10),
    SECOND_RATE("Hourly Rate2", 15),
    THIRD_RATE("Hourly Rate3", 20);

    HourlyRate(String rateName, float rateValue) {
        this.rateName = rateName;
        this.rateValue = rateValue;
    }

    private String rateName;
    private float rateValue;

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) throws IllegalArgumentException{

            if(rateName == null || rateName.trim().isEmpty()){
                throw new IllegalArgumentException("Rate name should not be empty!");
            }
            this.rateName = rateName;

    }

    public float getRateValue() {
        return rateValue;
    }

    public void setRateValue(float rateValue) throws IllegalArgumentException {
        if (rateValue < 0) // need?
                throw new IllegalArgumentException("Rate cannot be negative.");
            this.rateValue = rateValue;
    }
}
