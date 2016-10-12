package introduction.practice;

import util.Scan;

import static util.Print.println;
import static util.Scan.getInt;

/*
 * Define integer variables a and b.
 * Read values a and b from Console and calculate:
 * a + b, a - b, a * b, a / b.
 * Output obtained results.
 */
public class Calc {

    public static void main(String ... args){

        println("Enter two numbers: ");
        int a = getInt();
        int b = getInt();

        println("a + b = ", sum(a, b));
        println("a - b = ", sub(a, b));
        println("a * b = ", mult(a, b));
        try {
            println("a / b = ", div(a, b));
        } catch (ArithmeticException e){
            println("Cannot divide by zero");
        }

        Scan.scanner.close();
    }

    // Method return sum of two integer
    public static int sum(int a, int b){

        return a + b;
    }

    // Method return subtract of two integer
    public static int sub(int a, int b){

        return a - b;
    }

    // Method return multiply of two integer
    public static int mult(int a, int b){

        return a * b;
    }

    // Method return divide of two integer
    public static int div(int a, int b) throws ArithmeticException{

        return a / b;
    }

}


