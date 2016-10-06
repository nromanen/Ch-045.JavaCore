package introduction;

import static util.Print.print;
import static util.Print.println;
import static util.Scan.getDouble;


/**
 * Created by Ariezz on 28.09.16.
 */
public class FlowerBed {

    public static void main(String ... args){
        println("Enter radius of the flower bed in meters!");
        print("Radius = ");
        double radius = getDouble();

        Flower flower = new Flower(radius);

        println("Perimeter of the flower bed is ", flower.perimeter(), " m");
        println("Area of the flower bed is ", flower.area(), " m2");
    }

}

class Flower {
    private double radius;

    Flower(){
        radius = 1;
    }

    Flower(double radius){
        if (radius > 0) {
            this.radius = radius;
        } else {
         print("Radius cannot be negative");
            this.radius = 1;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    public double perimeter(){
        return Math.round(100 * 2 * radius * Math.PI)/100.0;
    }

    public double area (){
        return Math.round(100 * radius * radius * Math.PI)/ 100.0;
    }
}
