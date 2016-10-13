package net.gavrilyuk.talks;

/**
 *
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Country {

    private String isoCode;
    private String name;
    private double costOfMinute;// standard units per minute

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(double cost) {
        costOfMinute = cost;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostOfMinute() {
        return costOfMinute;
    }

    public void setCostOfMinute(double costOfMinute) {
        this.costOfMinute = costOfMinute;
    }
}
