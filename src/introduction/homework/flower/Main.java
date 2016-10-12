package introduction.homework.flower;

import util.Scan;
import static util.Print.print;
import static util.Print.println;
import static util.Scan.getDouble;


/*
 * Create console application. In method main() write code for solving next tasks:
 * Flower bed is shaped like a circle.
 * Calculate the perimeter and area by entering the radius.
 * Output obtained results.
 */
public class Main {

    public static void main(String ... args){

        println("Enter radius of the flower bed in meters!");
        print("Radius = ");
        double radius = getDouble();

        FlowerBed flower = new FlowerBed(radius);

        println("Perimeter of the flower bed is ", flower.perimeter(), " m");
        println("Area of the flower bed is ", flower.area(), " m2");

        Scan.close();
    }

}

