package stringandregex.homework.task3;

import util.Scan;

import static util.Print.println;

/*
 * Implement a pattern for US currency: the first symbol "$",
 * then any number of digits, dot and two digits after the dot.
 * Enter the text from the console that contains several occurrences of US currency.
 * Display all occurrences on the screen.
 */
public class Main {
    public static void main(String[] args) {
        println("Enter the text: ");
        String text = Scan.getString(0);

        for(String currency : Util.getCurrency(text)){
            println(currency);
        }
    }
}
