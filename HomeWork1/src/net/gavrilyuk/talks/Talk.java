package net.gavrilyuk.talks;


/**
 * Talk class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Talk {

    private double duration; // the duration of a call in minutes, may be 1.98
    private Country toCountry;

    public Talk() {
    }


    public String getPriceString() {
       return String.format("%,.2f",  toCountry.getCostOfMinute() * duration);
    }

    public double getPrice() {
        return  toCountry.getCostOfMinute() * duration;
    }

    public Talk(int duration) {
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Country getCountry() {
        return toCountry;
    }

    public void setToCountry(Country toCountry) {
        this.toCountry = toCountry;
    }

    public String getTalkString() {
        return "Call to " + getCountry().getName() + ": Coast of minute="+String.format("%,.2f", getCountry().getCostOfMinute()) + "  Duration = " +
                TalkUtil.getDurationToString(duration) + " Price=" + String.format("%,.2f", getPrice()) + " unit";
    }
}

