package net.gavrilyuk;

import java.util.Scanner;

/**
 *
 * Created by GipSoft on 18.10.2016.
 */

        /*Enter the two variables of type String.
        Determine whether the first variable substring second.
        For example, if you typed «IT» and «IT Academy» you must receive true*/
public class PTask1App {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String var1 = PrStringsUtil.readString(scanner, "Enter string:");
        String var2 = PrStringsUtil.readString(scanner, "Enter sub string:");
        System.out.println("String " + var2 + " is substring " + var1 + " =" + PrStringsUtil.isSubstring(var1, var2));
        scanner.close();
    }


}
