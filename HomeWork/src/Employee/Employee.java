package Employee;

/**
 * Created by evil on 06.10.16.
 */
class Employee {
    private static int totalSum;
    private String name;
    private double rate;
    private int hours;

    public Employee(){}

    public Employee(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Employee(String name, double rate, int hours) {
        this.name = name;
        this.rate = rate;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double salary() {
        return rate*hours;
    }

    public void changeRate(double newRate){
        this.rate = newRate;
    }

    public void setTotalSum(){
        totalSum+= hours;
    }
    public static int getTotalSum(){
        return totalSum;
    }
    public double bonuses(){return salary()/10;}

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\''
                + ", rate=" + rate + ", hours=" + hours
                + " salary=" + salary() + " bonuses= " + bonuses() + '}';
    }
}
