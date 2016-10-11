package lesson3.homework;

import util.Scan;

import static lesson3.homework.Util.getDayssmount;
import static util.Print.print;
import static util.Print.println;


public class Main1 {

    public static void main (String... args){

        print("Enter number of month: ");
        int month = Scan.getInt();
        println((getDayssmount(month)== -1)? "Incorrect number of month." : ("This month has " + getDayssmount(month) + " days"));

        Scan.close();
    }
}
