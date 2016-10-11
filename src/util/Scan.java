package util;

import java.util.Scanner;

/**
 * Created by Ariezz on 29.09.16.
 */
public class Scan {

    public static Scanner scanner = new Scanner(System.in);

    public static int getInt(){

        boolean isInt = false;
        String line;
        int result = 0;

        while (!isInt){
            try{
                line  = scanner.nextLine();
                result = Integer.parseInt(line);
                isInt = true;
            } catch (Exception e){
                System.out.println("This is not integer. Try again.");
            }
        }
        return result;
    }

    public static String getString(int min){

        String line = "";
        boolean isCorrect = false;

        while (!isCorrect){

            line  = scanner.nextLine();

            if (line.length()<min)
                System.out.println("To short. Try again.");
            else
                isCorrect = true;

        }

        return line;
    }

    public static double getDouble(){

        boolean isDouble = false;
        String line;
        double result = 0.0;

        while (!isDouble){
            try{
                line  = scanner.nextLine();
                result = Double.parseDouble(line);
                isDouble = true;
            } catch (Exception e){
                System.out.println("Error. Try again.");
            }
        }

        return result;
    }

    public static float getFloat(){

        boolean isFloat = false;
        String line;
        float result = 0.0f;

        while (!isFloat){
            try{
                line  = scanner.nextLine();
                result = Float.parseFloat(line);
                isFloat = true;
            } catch (Exception e){
                System.out.println("Error. Try again.");
            }
        }

        return result;
    }

    public static void close(){
        scanner.close();
    }
}
