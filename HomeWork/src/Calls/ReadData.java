package Calls;

import java.util.Scanner;


/**
 * Created by evil on 03.10.16.
 */
public class ReadData {
    private static double readConsole(){
        double x = 0;
        Scanner in = new Scanner(System.in);
        try {
            x = in.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid data");
        }
        while (!(x>0)){
            System.out.println("Must be more then 0");
            x = in.nextDouble();
        }
        return x;
    }

    public static void main(String[] args) {
        Calls firstCall = new Calls();
        Calls secondCall = new Calls();
        Calls thirdCall = new Calls();
        System.out.println("Print price for call 1");
        firstCall.setPricePerMinute(ReadData.readConsole());
        System.out.println("Call 2");
        secondCall.setPricePerMinute(ReadData.readConsole());
        System.out.println("Call 3");
        thirdCall.setPricePerMinute(ReadData.readConsole());
        System.out.println("Duration of call 1");
        firstCall.setDuration(ReadData.readConsole());
        System.out.println("Call 2");
        secondCall.setDuration(ReadData.readConsole());
        System.out.println("Call 3");
        thirdCall.setDuration(ReadData.readConsole());
        System.out.println("Price of first call: " +firstCall.priceForCall() + " ; "
                            + " second call: " + secondCall.priceForCall()
                            + " third call: " + thirdCall.priceForCall());
        System.out.println("Summary price is: " +
                    (firstCall.priceForCall()+secondCall.priceForCall()+thirdCall.priceForCall()));
    }
}
