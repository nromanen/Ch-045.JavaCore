package net.gavrilyuk.flowerbeds;

/**
 * Flower Bed Class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class FlowerBed {

    private double mRadius;
    private double mArea;
    private double mPerimeter;

    public FlowerBed() {
    }

    public FlowerBed(float mRadius) {
        this.mRadius = mRadius;
        calculate();
    }

    public double getArea() {
        return mArea;
    }

    public double getPerimeter() {
        return mPerimeter;
    }

    public double getRadius() {
        return mRadius;
    }

    public void setRadius(double radius) {
        mRadius = radius;
    }

    public void calculate() {
        mArea = Math.PI * Math.pow(mRadius, 2);
        mPerimeter = 2 * Math.PI * mRadius;
    }

    public String getData() {
        return String.format("Bed Radius=%,.2f  Area=%,.2f  Perimeter=%,.2f", mRadius, mArea, mPerimeter);
    }

}
