package net.gavrilyuk.dayofmonth;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class DayOfMonthUtil {
    public static int daysInMonth(int monthNumber, boolean isLeapYear)
    {
        int[] DAY_OF_MONTH = {31, isLeapYear ? 29 : 28, 30, 31, 31, 30, 31, 30, 31, 30, 31};
        if (monthNumber < 0 || monthNumber > DAY_OF_MONTH.length)
            return 0;
        switch(monthNumber)
        {
            case 1:
                return isLeapYear ? 29 : 28;
            case 2:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                return 31;
        }
    }
}
