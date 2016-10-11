package lesson3.homework.car;

import util.Scan;

import java.util.ArrayList;
import java.util.Collections;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class Main {

    public static void main (String ... args){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(CarType.MICROCAR, 1996, 2000));
        cars.add(new Car(CarType.ECONOMY_CAR, 2015, 1312));
        cars.add(new Car(CarType.CONVERTIBLE, 2015, 1500));
        cars.add(new Car(CarType.FULL_SIZE_CAR, 2014, 2500));
        cars.add(new Car(CarType.CARGO_VAN, 2005, 3000));


        print("Enter year of production of the car: ");
        int year = Scan.getInt();

        println("Cars production in " + year + " year:");

        CarService.printCars(year, cars);

        Collections.sort(cars, CarService.compareByYear);
        println();
        println("All cars: ");
        for (Car car : cars){
            println(car);
        }

    }
}
