package homework4.homework.car;

import homework4.homework.car.Car;

/**
 * Created by roma on 09.10.2016.
 */
public class MainCar {
    public static void main(String[] args){

        Car car = new Car();
        car.input();
        car.output();
        car.sortByYear();
        System.out.println("Ordered list by the field year");
        car.output();
    }
}
