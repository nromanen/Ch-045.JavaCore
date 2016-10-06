package Calls;

/**
 * Created by evil on 03.10.16.
 */
class Calls {
    private double pricePerMinute, duration;
    public Calls(){};
    public Calls(double pricePerMinute, double duration){
        this.pricePerMinute = pricePerMinute;
        this.duration = duration;
    }

    public void setPricePerMinute(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double priceForCall(){
        return duration * pricePerMinute;
    }

}
