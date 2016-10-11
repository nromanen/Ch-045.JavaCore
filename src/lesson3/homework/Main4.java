package lesson3.homework;

import util.Scan;

import java.util.ArrayList;
import static lesson3.homework.Util.product;
import static util.Print.println;

public class Main4 {

    public static  void main (String... args){

        println("Enter positive integer numbers.");
        ArrayList<Integer> list = new ArrayList<>();
        int num;
        while(true) {
            num = Scan.getInt();
            if (num < 0){
                break;
            }
            list.add(num);
        }

        println("Product of entered number is: " + product(list));

    }
}
