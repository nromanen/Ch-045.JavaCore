package net.gavrilyuk.cars;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Car {

    private int year;
    private float capacity;

    public Car(int year, float capacity) {
        this.year = year;
        this.capacity = capacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Year of production =" + year +
                ",Engine capacity=" + capacity + '}';
    }
}
