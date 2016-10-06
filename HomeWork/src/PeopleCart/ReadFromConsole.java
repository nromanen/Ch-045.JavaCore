package PeopleCart;

import java.util.Scanner;

/**
 * Created by evil on 02.10.16.
 */

public class ReadFromConsole {
    private static String readString() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }

    private static int readInt() {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        while (!(i>0 && i<120)){
            System.out.println("Invalid data, try again");
            i = in.nextInt();
        }
        return i;
    }

    public static void main(String[] args) {
        ManCart newMan = new ManCart();
        System.out.println("What is your name ?");
        String name = ReadFromConsole.readString();
        newMan.setName(name);
        System.out.println("How old are you ?");
        int age = ReadFromConsole.readInt();
        newMan.setAge(age);
        System.out.println("Where are you live, " +newMan.getName() + " ?");
        String address = ReadFromConsole.readString();
        newMan.setAddress(address);
        System.out.println(newMan.printCart());
    }
}