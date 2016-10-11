package lesson3.maxnegative;

import static lesson3.maxnegative.MaxNegative.getMaxNegative;
import static util.Print.println;

/**
 * Created by Admin on 10.10.16.
 */
public class Main {

    public static void main (String ... args) {

        int[] data = {0, 4, -8, 7, 8, -9, -1, 0, 9, 0};

        if (getMaxNegative(data)==0){
            println("There are not negative numbers");
        } else {
            println("Max negative numbers is " + getMaxNegative(data));
        }
    }
}
