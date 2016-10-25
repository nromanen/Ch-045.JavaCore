package exception.practice.task1;

import util.Scan;

import static exception.practice.task1.Util.squareRectangle;
import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 23.10.16.
 */
public class Main {
    public static void main(String[] args) {

        println("Enter the sides of rectangle.");
        print("a = ");
        int a = Scan.getInt();
        print("b = ");
        int b = Scan.getInt();

        try {
            println("The square of the rectangle with sides ", a, " and ", b, " is ", squareRectangle(a, b), ".");
        } catch (IncorrectDataException e){
            println(e.getMessage());
        }
    }
}
