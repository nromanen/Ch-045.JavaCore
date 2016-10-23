package stringandregex.practice.task3;

import util.Scan;

import static stringandregex.practice.task3.Util.isCorrectName;
import static util.Print.print;
import static util.Print.println;

/* The user name can be 3 to 15 characters of the Latin alphabet, numbers, and underscores.
 * The name can have 2 parts like describe, between parts of name must be "-".
 * Using regular expressions implement checking the user name for validity.
 * Input five names in the main method .
 * Output a message to the console of the validation of each of the entered names
 *
 */
public class Main {

    public static void main(String[] args) {

        int n = 5;
        String [] nameArray = new String[n];
        for (int i = 0; i < n; i++){
            print("Enter name: ");
            nameArray[i] = Scan.getString(0);
        }
        Scan.close();

        for (String name : nameArray) {
            println("Name ", name, (isCorrectName(name)? " is correct." : " isn't correct."));
        }

    }
}
