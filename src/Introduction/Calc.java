package introduction;

import util.Scan;

import static util.Print.println;
import static util.Scan.getInt;

/**
 * Created by Ariezz on 28.09.16.
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

    public static int sum(int a, int b){

        return a + b;
    }

    public static int sub(int a, int b){

        return a - b;
    }

    public static int mult(int a, int b){

        return a * b;
    }

    public static int div(int a, int b) throws ArithmeticException{

            return a / b;
    }

}


