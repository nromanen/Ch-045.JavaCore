package loopsandarrays.homework.tasks;

import util.Scan;

import static util.Print.print;
import static util.Print.println;

 /*
  * Ask user to enter the number of month.
  * Read the value and write the amount of days in this month (create array with amount days of each month).
  */

public class Main1 {

    public static void main (String... args){

        print("Enter number of month: ");
        int month = Scan.getInt();
        println((Util.getDaysAmount(month)== -1)? "Incorrect number of month." : ("This month has " + Util.getDaysAmount(month) + " days"));

        Scan.close();
    }
}
