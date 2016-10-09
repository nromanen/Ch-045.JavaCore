package net.gavrilyuk.cars;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class Car {

    private int mYear;
    private float mCapacity;

    public Car(int year, float capacity) {
        mYear = year;
        mCapacity = capacity;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public float getCapacity() {
        return mCapacity;
    }

    public void setCapacity(float capacity) {
        mCapacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Year of production =" + mYear +
                ",Engine capacity=" + mCapacity + '}';
    }
}
