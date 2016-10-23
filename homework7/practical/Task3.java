package homework7.practical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roma on 20.10.2016.
 * The user name can be 3 to 15 characters of the Latin alphabet, numbers, and underscores.
 * Using homework7 expressions implement checking the user name for validity.
 * Input five names in the main method .
 * Output a message to the console of the validation of each of the entered names.
 */
public class Task3 {
    public static void main(String[] args){

        String name1 = "Gtw-Supsssssssaadfd";
        System.out.println(Task3.isValidName(name1)?"valid name":"name not valid");

        String name2 = "Gt Supsssssssaadfdi";
        System.out.println(Task3.isValidName(name2)?"valid name":"name not valid");

        String name3 = "georg Franco";
        System.out.println(Task3.isValidName(name3)?"valid name":"name not valid");
    }
    public static boolean isValidName(String name){
        Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,14}(-[A-Z]{1}[a-z]{2,14})?");
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
