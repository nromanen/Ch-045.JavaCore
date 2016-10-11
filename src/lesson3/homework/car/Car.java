package lesson3.homework.car;


public class Car {

    private CarType type;
    private int year;
    private int capacity;

    public Car(CarType type, int year, int capacity) {
        this.capacity = capacity;
        this.type = type;
        if (CarService.correctYear(year)) {
            this.year = year;
        } else {
            this.year = 2016;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (CarService.correctYear(year)) {
            this.year = year;
        } else {
            this.year = 2016;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getYear() != car.getYear()) return false;
        if (getCapacity() != car.getCapacity()) return false;
        return !(getType() != null ? !getType().equals(car.getType()) : car.getType() != null);

    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + getYear();
        result = 31 * result + getCapacity();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "capacity=" + capacity +
                ", type=" + type +
                ", year=" + year +
                '}';
    }
}
