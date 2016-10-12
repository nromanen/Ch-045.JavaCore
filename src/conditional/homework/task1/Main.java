package conditional.homework.task1;

import util.Scan;

import static conditional.homework.task1.Util.inRange;
import static conditional.homework.task1.Util.maxOfThreInt;
import static util.Print.print;
import static util.Print.println;

 /*
  * Solve the next tasks:
  *     read 3 float numbers and check: are they all belong to the range [-5,5];
  *     read 3 integer numbers and write max and min of them;
  */
public class Main {

    public static void main (String ... args){
        int n = 3;
        float data [] = new float[n];


        print("Enter min of range: ");
        int min = Scan.getInt();
        print("Enter max of range: ");
        int max = Scan.getInt();
        println("Enter items of array.");
        for( int i = 0; i < n; i++){
            data[i] = Scan.getFloat();
        }
        if (inRange(min, max, data)){
            println("All numbers is in range [" + min + ", " + max + "].");
        } else {
            println("Not all numbers is in range [" + min + ", " + max + "].");
        }

        println("Enter 3 integers:");
        int a = Scan.getInt();
        int b = Scan.getInt();
        int c = Scan.getInt();

        println("Max of this numbers is: " + maxOfThreInt(a, b, c));

        Scan.close();
    }
}
