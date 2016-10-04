package introduction;

import static introduction.Calc.print;
import static introduction.Calc.println;
import static introduction.Scan.getDouble;

/**
 * Created by Ariezz on 29.09.16.
 */
public class CallCount {

    public static void main(String ... args){
        double total = 0.0;
        Call call = new Call();
        for (int i = 0; i < 3; i++){
            print("Enter price of the call $ per minute: ");
            call.setPrice(getDouble());
            print("Enter duration of the call in minutes: ");
            call.setDuration(getDouble());
            println("You have to pay: ",  count(call.getPrice(), call.getDuration())," $.");
            total += count(call.getPrice(), call.getDuration());
        }
        print("Total: ", total, " $.");

        Scan.scanner.close();
    }


    public static double count(double price, double duration){

        return Math.round(100 *price * duration)/100.00;
    }

}

class Call {
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
}


