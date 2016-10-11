package homework4.homework.car;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by roma on 09.10.2016.
 *
 * Create class Car with fields type, year of production and engine capacity.
 * Create and initialize four instances of class Car.
 * Display cars
        * certain model year  (enter year in the console);
        * ordered by the field year.
 */
public class Car implements Comparable<Car> {

    static DateTime yearNow = new DateTime();
    static int startYearProduction = 1950;

    private String type;
    private DateTime yearProduction;

    private double engineCapacity;
    private List<Car> cars;

    public Car(){
    }

    public  Car(String type, int yearProduction, double engineCapacity){
        this.type = type;
        this.yearProduction = new DateTime().withYear(yearProduction);
        this.engineCapacity = engineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateTime getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction =  new DateTime().withYear(yearProduction);
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void input(){

        Car car1 = new Car( "luxury", 2000, 3.5 );
        Car car2 = new Car( "sports", 1985, 2.0 );
        Car car3 = new Car( "large", 1985, 1.8 );
        Car car4 = new Car( "midsize", 2000, 2.3 );
        Car car5 = new Car( "small", 1975, 2.4 );

        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    public void sortByYear(){
        Collections.sort(cars);
    }

    public void output(){
        for (Car car: cars){
            System.out.println(car);
        }
        System.out.println();
    }

    public int inputYear(String name){
        int result = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Input year production "+name+" ('yyyy') :");
            while(!scan.hasNextInt()){
                System.out.print("not (yyyy) year, enter true year: ");
                scan.next();
            }
            result = scan.nextInt();
        } while ((result > yearNow.getYear()) | (result < startYearProduction ));
        return result;
    }

    @Override
    public String toString(){
        return String.format("Type: %-8s  year production: %d  engine capacity: %.2f",type,yearProduction.getYear(),engineCapacity);
    }

    @Override
    public int compareTo(Car o) {
        return getYearProduction().compareTo(o.getYearProduction());
    }
}
