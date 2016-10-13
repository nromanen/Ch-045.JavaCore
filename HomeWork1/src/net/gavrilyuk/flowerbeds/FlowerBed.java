package net.gavrilyuk.flowerbeds;

/**
 * Flower Bed Class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class FlowerBed {

    private double radius;
    private double area;
    private double perimeter;

    public FlowerBed() {
    }

    public FlowerBed(float mRadius) {
        this.radius = mRadius;
        calculate();
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void calculate() {
        area = Math.PI * Math.pow(radius, 2);
        perimeter = 2 * Math.PI * radius;
    }

    public String getData() {
        return String.format("Bed Radius=%,.2f  Area=%,.2f  Perimeter=%,.2f", radius, area, perimeter);
    }

}
