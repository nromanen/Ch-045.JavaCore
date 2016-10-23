package homework7.homework;

/**
 * Created by roma on 23.10.2016.
 * Implement a pattern for US currency: the first symbol "$",
 * then any number of digits, dot and two digits after the dot.
 * Enter the text from the console that contains several occurrences of US currency.
 * Display all occurrences on the screen.
 */
public class Task3 {
    public static void main(String[] args){
        String text =   "$2343.123, " +
                        "$123.45, " +
                        "$3455 " +
                        "$12324.36";

        //Display all occurrences on the screen
        System.out.println(Util.displayAllOccurrenceUS(text));
    }

}
