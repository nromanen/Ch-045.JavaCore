package net.gavrilyuk.cars;

import java.util.Calendar;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Car {

    private int year;
    private float capacity;

    public Car(int year, float capacity) throws CarException {
        if (!correctYears(year)) throw new CarException(1, year+" is invalid year!");
        this.year = year;
        if (!correctCapacity(capacity)) throw new CarException(2, capacity+" invalid capacity!");
        this.capacity = capacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws CarException{
        if (!correctYears(year)) throw new CarException(1,year+" is invalid year!");
        this.year = year;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        if (!correctCapacity(capacity)) throw new CarException(2, capacity + " invalid capacity!");
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Year of production =" + year +
                ",Engine capacity=" + capacity + '}';
    }

    public static boolean  correctYears(int year) {
        return year <= Calendar.getInstance().get(Calendar.YEAR);
    }
    public static boolean  correctCapacity(float capacity) {
        return capacity > 0;
    }

}
