package lesson3.homework.car;

import lesson3.dog.Dog;

import java.util.ArrayList;
import java.util.Comparator;

import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class CarService {

    public static boolean correctYear(int year){
        if (year >= 1920 && year <= 2016) {
            return true;
        } else {
            return false;
        }
    }

    public static Comparator<Car> compareByYear = new Comparator<Car>() {
        public int compare(Car car1, Car car2) {
            return car1.getYear() - car2.getYear();
        }
    };

    public static void printCars(int year, ArrayList<Car> cars){
        for (Car car : cars){
            if (car.getYear() == year){
                println(car);
            }
        }
    }


}
