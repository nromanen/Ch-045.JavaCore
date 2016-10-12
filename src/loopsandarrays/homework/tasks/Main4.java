package loopsandarrays.homework.tasks;

import util.Scan;

import java.util.ArrayList;

import static util.Print.print;
import static util.Print.println;

/*
  * Organize entering integers until the first negative number. Count the product of all entered even numbers.
  */



public class Main4 {

    public static  void main (String... args){

        println("Enter positive integer numbers.");
        ArrayList<Integer> list = new ArrayList<>();
        int num;
        int count = 1;
        while(true) {
            num = Scan.getInt();
            count++;
            if (num < 0 ){
                break;
            }
            if (count % 10 == 0){
                print("Do you want to continue? (Y/N): ");
                String cont = Scan.getString(1);
                if (!cont.toUpperCase().equals("Y")){
                    break;
                }
            }
            list.add(num);
        }

        println("Product of entered number is: ",  Util.product(list));

    }
}
