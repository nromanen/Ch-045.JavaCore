package net.gavrilyuk.person;

import java.util.Scanner;

/**
 *
 * Created by GipSoft on 28.09.2016.
 */
public class AppPerson {

    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("How old are you?");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result > 0) {
                    if ( result <200) {
                        break;
                    } else {
                        System.out.println("Let God give you health!");
                        System.out.print("How old are you?");
                    }
                } else {
                    System.out.println("Age must be >0!");
                    System.out.print("How old are you?");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("How old are you?");
            }
        }
        return result;
    }

    private static String readString(Scanner scanner, String questions) {
        String line = null;
        System.out.print(questions);
        while (scanner.hasNext()) {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.length() > 0) {
                    break;
                } else {
                    System.out.println("value must be not empty!");
                    System.out.print(questions);
                }

        }
        return line;
    }


    public static void main(String[] args) {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        String name = readString(scanner, "What is your name?");
        person.setName(TxtUtil.toCapsFirstLetter(name));
        int age = readInt(scanner);
        person.setAge(age);
        String address = readString(scanner,"Where are you live, "+person.getName()+"?");
        person.setAddress(address);
        System.out.println("Task result:" + person.getPersonData());
    }
}
