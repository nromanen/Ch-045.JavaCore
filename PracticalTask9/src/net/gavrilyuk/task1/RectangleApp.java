package net.gavrilyuk.task1;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class RectangleApp {


    /*Create a method for calculating the area of a rectangle int squareRectangle (int a, int b),
    which should throw an exception if the user enters negative value.
    Input values a and b from console.
    Check the squareRectangle method in the method main.
    Check to input nonnumeric value.*/


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = RectangleUtils.readLengthOfSide(scanner, "a");
        int b = RectangleUtils.readLengthOfSide(scanner, "b");
        try {
            /*Rectangle rectangle = new Rectangle(-1, -2);
            Rectangle rectangle = new Rectangle();
            rectangle.setA(-2);
            rectangle.setB(-2);*/
            Rectangle rectangle = new Rectangle(a, b);
            System.out.println("Rectangle square=" + rectangle.squareRectangle());
            System.out.println("Rectangle perimeter=" + rectangle.perimeterRectangle());
        } catch (RectangleSideException e) {
            System.out.println(e.getMessage());//ignore it
        }
        scanner.close();
    }
}
