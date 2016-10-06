package homework2.person;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by roma on 05.10.2016.
 */
public class Main {
    public static void main(String[] args){
        Person person = new Person();
        person.input();
        person.output();
    }

        /*



        public static void main(String args[]) {

            Date date = new Date();

            //System.out.println(date.toString());

            LocalDate birthYear = LocalDate.of(1985, 02, 17);

            long ageCount = ChronoUnit.YEARS.between(birthYear, LocalDate.now());
            System.out.println(ageCount);

            Date today = new Date();

            Date birthday = stringToDate("17.02.1985");
            long ageUser = today.getTime() - birthday.getTime();

           // System.out.print("UsrAge = "+ new Date(ageUser));
            // Date birthday = stringToDate("April 23, 2016");

            //System.out.println(today);
            System.out.println(birthday);

        }

        public static Date stringToDate(String str) {
            SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            Date parsedDate = new Date();
            //GregorianCalendar parsedDate = new GregorianCalendar();

            try {
                parsedDate = format1.parse(str);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            return parsedDate;
        }
    public static Date stringToDateLoc(String str) {
        SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = new Date();
        //GregorianCalendar parsedDate = new GregorianCalendar();

        try {
            parsedDate = format1.parse(str);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return parsedDate;
    }
    */
}
