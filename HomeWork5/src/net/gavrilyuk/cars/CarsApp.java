package net.gavrilyuk.cars;

import java.util.Scanner;

/**
 *  Create class Car with fields type, year of production and engine capacity.
 *  Create and initialize four instances of class Car.
 *  Display cars certain model year  (enter year in the console);
 *  ordered by the field year.

 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class CarsApp {
    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter the year of production of the car:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter the year of production of the car:");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cars cars = new Cars();
        cars.fillList(4);
        cars.orderByYears();
        System.out.println(cars.toString());
        int year = readInt(scanner);
        System.out.println(cars.filterByYear(year));
        scanner.close();
    }
}
