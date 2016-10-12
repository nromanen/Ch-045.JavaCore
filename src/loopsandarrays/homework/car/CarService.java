package loopsandarrays.homework.car;

import java.util.ArrayList;
import java.util.Comparator;

import static util.Print.println;


public class CarService {

    // check is year correct
    public static boolean correctYear(int year){
        if (year >= 1920 && year <= 2016) {
            return true;
        } else {
            return false;
        }
    }

    // compare cars by year
    public static Comparator<Car> compareByYear = new Comparator<Car>() {
        public int compare(Car car1, Car car2) {
            return car1.getYear() - car2.getYear();
        }
    };

    // display all cars with carent year
    public static void printCars(int year, ArrayList<Car> cars){
        for (Car car : cars){
            if (car.getYear() == year){
                println(car);
            }
        }
    }


}
