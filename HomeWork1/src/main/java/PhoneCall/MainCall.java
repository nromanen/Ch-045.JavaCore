package PhoneCall;

import inputMethod.Input;

import java.util.Scanner;

/**
 * Created by roma on 01.10.2016.
 */
public class MainCall {

    private int numCall;
    private Call[] calls;

    public static void main(String[] args){
        new MainCall().allAction();
    }

    private void allAction(){
        input();
        System.out.println("======================================");
        output();
    }

    private void input(){
        numCall = Input.inputInt("Enter number of call");
        //numCall = inputInt("Enter the number of call");
        calls = new Call[numCall];
        for (int i=0; i<calls.length; i++){
            calls[i] = inputCall(i);
        }
    }

    private Call inputCall(int callIndex ){
        double duration = Input.inputDouble("Input duration call_" + (callIndex + 1));
        double cost = Input.inputDouble("Input cost call_"+(callIndex+1));

        Call calls = new Call(duration, cost);
        return  calls;
    }

    private void output(){

        Call call = new Call();
        double startTimeAllSum = System.nanoTime();
        double allSum = call.getSumAll(calls);
        double durationTimeAllSum = System.nanoTime() - startTimeAllSum;


        for (int i=0; i<calls.length; i++){
            double cost = calls[i].getCost();
            double duration = calls[i].getDuration();

            double startTimeGetSum = System.nanoTime();
            double sum = calls[i].getSum(cost,duration);
            double durationTimeGetSum = System.nanoTime() - startTimeGetSum;

            System.out.printf("Phone call-"+(i+1)+"\nCost %.2f",cost);
            System.out.printf(" X Duration %.2f\n",duration);
            System.out.printf("Sum = %.2f",sum);
            System.out.println("\nComputer counts the cost of call: " + durationTimeGetSum + "(nanoseconds)");
            System.out.println("-------------------------------------");
        }
        System.out.printf("Sum of all calls:%.3f", allSum);
        System.out.println("\nComputer counts all talks together: "+durationTimeAllSum+"(nanoseconds)");
    }
/*
    public double inputDouble(String message){
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
    public int inputInt(String message) {
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
*/
}
