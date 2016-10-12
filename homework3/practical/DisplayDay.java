package homework3.practical;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * Created by roma on 12.10.2016.
 *
 * Enter the number of the day of the week.
 * Display the name in three languages.
 */
public class DisplayDay {
    public static void main(String [] args){

        int number = DisplayDay.inputInt();
        System.out.println("Display the name in three languages: " + DisplayDay.getDayName(number));

    }
    public static String getDayName(int dayNumber){
        if( (dayNumber >= 1)&(dayNumber <=7)) {

            String[] weekDaysGe = new DateFormatSymbols(Locale.GERMANY).getWeekdays();
            String[] weekDayUs = new DateFormatSymbols(Locale.ENGLISH).getWeekdays();
            String[] weekDayFr = new DateFormatSymbols(Locale.CHINA).getWeekdays();

            return    weekDaysGe[dayNumber] + ", "
                    + weekDayFr[dayNumber] + ", "
                    + weekDayUs[dayNumber];
        }
        return "Not day number";
    }

    public static int inputInt() {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of day [1-7] : ");
        while (scan.hasNextInt()){
            result = scan.nextInt();
            if( (result >= 1) & (result <= 7) ){ break; }
            else {
                System.out.print("Not correct number of the week day :");
            }
        }
        scan.close();
        return result;
    }
}
