package net.gavrilyuk.talks;

/**
 *
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Country {

    private String mISOCode;
    private String mName;
    private double mCostOfMinute;// standard units per minute

    public Country() {
    }

    public Country(String name) {
        mName = name;
    }

    public Country(double cost) {
        mCostOfMinute = cost;
    }

    public String getISOCode() {
        return mISOCode;
    }

    public void setISOCode(String ISOCode) {
        mISOCode = ISOCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getCostOfMinute() {
        return mCostOfMinute;
    }

    public void setCostOfMinute(double costOfMinute) {
        mCostOfMinute = costOfMinute;
    }
}
