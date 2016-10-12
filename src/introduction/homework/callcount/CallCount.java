package introduction.homework.callcount;

import util.Scan;

import java.util.ArrayList;
import java.util.List;

import static util.Print.print;
import static util.Print.println;
import static util.Scan.getDouble;
import static util.Scan.getString;

 /*
  * Phone calls from three different countries are ñ1, ñ2 and ñ3 standard units per minute.
  * Talks continued t1, t2 and t3 minutes.
  * How much computer will count for each call separately and all talk together?
  * Input all source data from console, make calculations and output to the screen.
  */

public class CallCount {

    public static void main(String ... args){
        double total = 0.0;
        List<Call> calls = new ArrayList<>();

        while (true){
            print("Enter price of the call $ per minute: ");
            double price = getDouble();
            print("Enter duration of the call in minutes: ");
            double duration = getDouble();
            calls.add(new Call(price, duration));
            print("Do you want enter new call information? (Y/N): ");
            String exit = getString(1);
            if(!exit.toUpperCase().equals("Y")){
                break;
            }
        }

        println();
        int i = 1;
        for(Call call : calls){
            println("For the ", i++, "-th call you have to pay: ",  call.count()," $.");
            total += call.count();
        }

        print("Total sum: ", total, " $.");

        Scan.close();
    }

}


