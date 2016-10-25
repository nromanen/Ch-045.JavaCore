package net.gavrilyuk;

import java.util.Scanner;

/**
 *
 * Created by GipSoft on 18.10.2016.
 */

        /*Enter surname, name and patronymic on the console as a variable of type String. Output on the console:
        surnames and initials
        name
        name, middle name and last name*/

public class PrTask2App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String name = StringsUtils.readString(scanner, "Enter surname, name and patronymic:");
        try {
            String name = "  Гаврилюк     ігор    петрович                        ";
            if (!StringsUtils.isAlpha(name)) throw new IllegalArgumentException("Invalid surname, name or patronymic");
            //name = StringsUtils.toCapsWord(name);//deleted spaces
            String[] names = name.split("\\s");
            System.out.println(names[0] + " " + names[1].charAt(0) + "." + names[2].charAt(0)+  ".");
            System.out.println(names[1]);
            System.out.println(names[1] + " " + names[2] + " " + names[0]);
        } catch (ArrayIndexOutOfBoundsException e) {//name[i]
            System.out.println("Empty surname, name or patronymic");
        } catch (StringIndexOutOfBoundsException es) {//charAt
            System.out.println("String index out of range");
        }
        // Question replace two catch(ArrayIndexOutOfBoundsException,StringIndexOutOfBoundsException)
        // one IndexOutOfBoundsException ?
        catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
        }
        scanner.close();
    }
}