package loopsandarrays.homework.car;

import java.util.*;

import static util.Print.println;


public class CarService {

    // check is year correct
    public static boolean correctYear(int year){
        if (year >= 1885 && year <= (new GregorianCalendar()).get(Calendar.YEAR)) {
            println((new GregorianCalendar()).get(Calendar.YEAR));
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

    // display all cars with carrent year
    public static void printCarsByYear(int year, ArrayList<Car> cars){
        for (Car car : cars){
            if (car.getYear() == year){
                println(car);
            }
        }
    }


}
