package homework1.flowerbed;

import homework1.inputmethod.Input;

public class FlowerBed {

    private double radius;

    public static void main(String[] args){

        FlowerBed flower = new FlowerBed();
        flower.allAction();
    }

    private void allAction(){
        radius = Input.inputDouble("Enter radius flower bed");
        output(radius);
    }

    private void output(double radius){
        System.out.printf("Flower bed area      = %.4f%n", getArea(radius));
        System.out.printf("Flower bed perimeter = %.4f%n", getPerimeter(radius));
    }

    private double getArea(double radius) {
        return Math.PI*radius*radius;
    }
    private double getPerimeter(double radius){
        return 2*Math.PI*radius;
    }
}
