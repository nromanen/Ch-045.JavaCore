package FlowerBed;

import java.util.Scanner;

/**
 * Created by evil on 03.10.16.
 */
public class InputConsole {
    private static double readRadius(){
        Scanner in = new Scanner(System.in);
        double radius = 0;
        try {
            System.out.println("Tip radius(use comma for float number)");
            radius = in.nextDouble();
        } catch (Exception e){
            System.out.println("Invalid data, try again");
        }
        while (!(radius>0)){
            System.out.println("Invalid data, must be more then 0");
            radius = InputConsole.readRadius();
        }
        return radius;
    }

    public static void main(String[] args) {
        double radius = InputConsole.readRadius();
        FlowerBed newBed = new FlowerBed(radius);
        System.out.println("Perimeter is " +newBed.circlePerimeter());
        System.out.println("Area is " + newBed.circleArea());
    }
}
