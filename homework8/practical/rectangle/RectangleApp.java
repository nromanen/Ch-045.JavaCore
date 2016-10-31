package homework8.practical.rectangle;

import java.io.IOException;

/**
 * Created by roma on 27.10.2016.
 * Create a method for calculating the area of a rectangle int squareRectangle (int a, int b),
 * which should throw an exception if the user enters negative value.
 * Input values a and b from console. Check the squareRectangle method in the method main.
 * Check to input nonnumeric value.

 */
public class RectangleApp {
    public static void main(String[] args){

        int a = Utils.readIntVal("a");
        int b = Utils.readIntVal("b");

        try {
            System.out.println("Rectangle square = "+Rectangle.square(a, b));
        } catch (NegativeValueException e) {
            System.out.print(e);
        }
    }
}
