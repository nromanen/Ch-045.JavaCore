package homework5.employees;

/**
 * Created by roma on 13.10.2016.
 */
public enum HourlyRate {
    RATE_20(20),
    RATE_30(30),
    RATE_40(40);

    public int hourlyRate;

    HourlyRate(int hourlyRate) {
         this.hourlyRate = hourlyRate;
    }
}
