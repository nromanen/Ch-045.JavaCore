package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Ariezz on 29.09.16.
 */
public class Scan {

    //public static Scanner scanner = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(){

        boolean isInt = false;
        String line;
        int result = 0;

        while (!isInt){
            try{
                //line  = scanner.nextLine();
                line  = br.readLine();
                result = Integer.parseInt(line);
                isInt = true;
            } catch (Exception e){
                System.out.println("This is not integer. Try again.");
            }
        }
        return result;
    }

    public static String getString(int... min){

        String line = "";
        boolean isCorrect = false;

        try {
            if (min.length == 0) {
              return br.readLine();
            }

            if(min[0] < 0){
                min[0] = 0;
            }

            while (!isCorrect) {

                //line  = scanner.nextLine();
                line = br.readLine();

                if (line.length() < min[0])
                    System.out.println("To short. Try again.");
                else
                    isCorrect = true;

            }
        } catch (IOException e){
         println("Error.");
        }

        return line;
    }

    public static double getDouble(){

        boolean isDouble = false;
        String line;
        double result = 0.0;

        while (!isDouble){
            try{
                //line  = scanner.nextLine();
                line  = br.readLine();
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
                //line  = scanner.nextLine();
                line  = br.readLine();
                result = Float.parseFloat(line);
                isFloat = true;
            } catch (Exception e){
                System.out.println("Error. Try again.");
            }
        }

        return result;
    }

    public static void close(){

        //scanner.close();
        try {
            br.close();
        } catch (IOException e){
            println("Error");
        }
    }
}
