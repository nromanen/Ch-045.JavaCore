package lesson3.days;

import util.Scan;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 10.10.16.
 */
public class Main {

    public static void main (String ... args){

        print("Enter the number of weeks day: ");
        int nDay = Scan.getInt();


        if (nDay > 0 && nDay <=7){
            println("Name of the " + nDay + " day of the week is: ");
            println("English: " + DaysEng.getDay(nDay));
            println("Germany: " + DaysGerm.getDay(nDay));
            println("Russia: " + DaysRus.getDay(nDay));
        } else {
            println("Error. Incorrect number of the day of the week");
        }

        Scan.close();

    }
}
