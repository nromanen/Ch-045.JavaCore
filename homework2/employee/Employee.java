package homework2.employee;

/**
 * Created by roma on 04.10.2016.
 */
public class Employee {
    static int bonuses = 10;
    static int totalSum = 0;
    static  int totalHours = 0; //total hours of all workers

    private String name;
    private int rate;
    private int hours;

    public Employee(){
    }

    public Employee(String name, int rate){
        this.name = name;
        this.rate = rate;
    }

    public Employee(String name, int rate, int hours){
        this.name = name;
        this.rate = rate;
        this.hours = hours;
        totalHours +=hours;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setHours(int hours) {
        this.hours = hours;
        totalHours +=hours;
    }

    public int getHours() {
        return hours;
    }

    public int salary(){
        totalSum += this.rate * this.hours;
        return this.rate * this.hours;
    }

    public double salary(int bonuses){
        return ((this.salary()) * (100 + bonuses) )/100;
    }

    public void changeRate(int rate){
        this.rate = rate;
    }

    @Override
    public String toString(){
        return "[name = "+name+", rate= "+rate+", hours= "+hours+"]";
    }
}
