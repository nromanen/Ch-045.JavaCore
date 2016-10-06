package homework1.inputmethod;

import java.util.Scanner;


/**
 * Created by roma on 02.10.2016.
 */
public class Input {

    public static int inputInt(String message) {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            while(!scan.hasNextInt()){
                System.out.print("not (int) number, enter true number: ");
                scan.next();
            }
            result = scan.nextInt();
        } while (result <= 0);
        return result;
    }

    public static double inputDouble(String message){
        double result = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            while(!scan.hasNextDouble()){
                System.out.print("not (double) number, enter true number: ");
                scan.next();
            }
            result = scan.nextDouble();
        } while (result <= 0);
        return result;
    }

    public static String inputName(String message){
        Scanner scan = new Scanner(System.in);
        System.out.print(message + ":");
        return scan.next();
    }

    public static String inputAdr(String message){
        Scanner scan = new Scanner(System.in);
        System.out.print(message + ":");
        return scan.nextLine();
    }
    public void testGit(){
        System.out.print("");
    }
}
