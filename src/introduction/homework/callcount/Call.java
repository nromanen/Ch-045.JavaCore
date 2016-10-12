package introduction.homework.callcount;

/**
 * Created by Admin on 12.10.16.
 */
public class Call {
    private double price = 0.0;
    private double duration = 0.0;

    public Call(){
    }

    public Call(double price, double duration) {
        if (duration > 0){
            this.duration = duration;
        }
        if (price > 0) {
            this.price = price;
        }
    }

    //seters and geters
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration > 0){
            this.duration = duration;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    //Method return price of the call
    public double count(){

        return Math.round(100 * this.price * this.duration)/100.00;
    }
}
