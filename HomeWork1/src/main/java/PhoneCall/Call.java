package PhoneCall;

/**
 * Created by roma on 01.10.2016.
 */
public class Call {
    private double duration;
    private double cost;

    public Call(){}

    public Call (double duration, double cost){
        super();
        this.duration = duration;
        this.cost = cost;
    }

    public double getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }
    public double getSum(double duration, double cost){
        return duration * cost;
    }
    public  double getSumAll(Call calls[]){
        double rez=0;
        for(Call call: calls){
            rez += call.cost*call.cost;
        }
        return rez;
    }
}
