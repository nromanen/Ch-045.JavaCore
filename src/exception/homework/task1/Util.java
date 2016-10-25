package exception.homework.task1;


public class Util {

    // Method read two double numbers d1 and d2 and return divide d1/d2
    public static double div(double d1, double d2) {

        if (d2 == 0){
            throw new ArithmeticException("Divide by zero");
        }

        return d1/d2 ;
    }
}
