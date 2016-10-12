package loopsandarrays.practice.maxnegative;

import static loopsandarrays.practice.maxnegative.MaxNegative.getMaxNegative;
import static util.Print.println;

 /*
  * Create console application. Find the max negative number of thr array and display it
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
