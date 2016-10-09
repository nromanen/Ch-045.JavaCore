package net.gavrilyuk.cars;

import java.util.*;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Cars {

    private AbstractList<Car> mCars;

    public Cars() {
        mCars = new ArrayList<>();
    }

    public AbstractList<Car> getCars() {
        return mCars;
    }

    public void setCars(AbstractList<Car> cars) {
        mCars = cars;
    }

    @Override
    public String toString() {
        return "Cars=" + mCars ;
    }

    public String filterByYear(int year) {
        StringBuilder builder = new StringBuilder();
        for (Car car : mCars) {
            if (car.getYear()==year) builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

    public void orderByYears() {
        Collections.sort(mCars, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                if (c1.getYear() < c2.getYear())
                    return -1;
                if (c1.getYear() == c2.getYear())
                    return 0;
                return 1;
            }
        });
    }

    public void fillList(int carCount) {
        if (mCars==null) mCars= new ArrayList<>();
        for (int j = 0; j < carCount; j++) {
            mCars.add(new Car(1990 + (j * 6), 0.95f * (j+1)));
        }
    }
}
