package net.gavrilyuk.talks;


/**
 * Talk class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Talk {

    private double mDuration; // the duration of a call in minutes, may be 1.98
    private Country mToCountry;

    public Talk() {
    }


    public String getPriceString() {
       return String.format("%,.2f",  mToCountry.getCostOfMinute() * mDuration);
    }

    public double getPrice() {
        return  mToCountry.getCostOfMinute() * mDuration;
    }

    public Talk(int duration) {
        mDuration = duration;
    }

    public double getDuration() {
        return mDuration;
    }

    public void setDuration(double duration) {
        mDuration = duration;
    }

    public Country getCountry() {
        return mToCountry;
    }

    public void setToCountry(Country toCountry) {
        mToCountry = toCountry;
    }

    public String getTalkString() {
        return "Call to " + getCountry().getName() + ": Coast of minute="+String.format("%,.2f", getCountry().getCostOfMinute()) + "  Duration = " +
                TalkUtil.getDurationToString(mDuration) + " Price=" + String.format("%,.2f", getPrice()) + " unit";
    }
}

