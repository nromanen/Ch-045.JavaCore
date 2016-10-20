package net.gavrilyuk;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 20.10.2016.
 */

        /*Implement a pattern for US currency:
        the first symbol "$", then any number of digits, dot and two digits after the dot.
        Enter the text from the console that contains several occurrences of US currency.
        Display all occurrences on the screen.*/

public class Task3App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
                           //ok   //ok     //ok      //ok  //ok //ok       //bugs        //ok        //ok   //ok //ok    //ok
        String source = "$ 12.68  1234.680 1234.$68  $s12d test $12345.10  $12345.001    $1234534.00 $1.12 $1sd  1sd2$   23323.00$ ";
        //String source = StringsUtil.readString(scanner, "Enter the text that contains several occurrences of US currency [Ex: $123.01 ]:");
        try {
            System.out.println("Source=" + source);
            System.out.println("Result=\'" + StringsUtil.checkRegExp(source) + "\'");
        } catch (NullPointerException npe) {
            System.out.println("Source string cannot be null");
        }
        scanner.close();
    }
}
