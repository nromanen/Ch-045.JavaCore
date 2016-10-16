package net.gavrilyuk.cars;

import java.util.*;

/**
 * Cars Class
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        if (cars != null) {
            this.cars = cars;
        }
    }

    @Override
    public String toString() {
        return "Cars=" + cars;
    }

    //fix teacher comments
    public List<Car> filterByYear(int year) throws CarException {
        List<Car> result = new ArrayList<>();
        if (!Car.correctYears(year)) throw new CarException(1,year +" is invalid year!");
        if (cars != null) {
            for (Car car : cars) {
                if (car.getYear() == year) {
                    result.add(car);
                }
            }
        }
        return result;
    }

    //fix teacher comments
    public List<Car> orderByYears() {
        List<Car> result;
        if (cars != null) {
            result = new ArrayList<>(cars);
            Collections.sort(result, new Comparator<Car>() {
                @Override
                public int compare(Car c1, Car c2) {
                    if (c1.getYear() < c2.getYear())
                        return -1;
                    if (c1.getYear() == c2.getYear())
                        return 0;
                    return 1;
                }
            });

        } else result = new ArrayList<>();
        return result;
    }
    // fill list
    public void fillList(int carCount) throws CarException {
            if (cars == null) cars = new ArrayList<>();
            if (carCount < 0) throw new CarException(3, "Count must be >0");
            for (int j = 0; j < carCount; j++) {
                cars.add(new Car(1990 + (j * 6), 0.95f * (j + 1)));
            }

    }
}
