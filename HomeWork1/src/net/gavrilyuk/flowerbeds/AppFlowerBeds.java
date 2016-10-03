package net.gavrilyuk.flowerbeds;

import java.util.Scanner;

/**
 * AppFlowerBeds app Class
 * Created by Igor Gavrilyuk on 29.09.2016.
 */
public class AppFlowerBeds {



    // read double value from console
    private static double readDouble(Scanner scanner) {
        String line = null;
        double result = 0;
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Double.parseDouble(line);
                if (result >= 0) {
                    break;
                } else {
                    System.out.println("radius must be >=0 !");
                    System.out.print("Enter the radius of the beds:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter the radius of the beds:");
            }
        }
        return result;
    }


    private static void printMenu() {
        System.out.println("------- Assistant gardener ------");
        System.out.println("1 - To read data from the flower_db;");
        System.out.println("2 - Add Flower Bed to flower_db;");
        System.out.println("3 - Exit;");
        System.out.println("Please select item:");
    }


    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            try {
                int choice = Integer.parseInt(line);
                switch (choice) {
                    case 1:
                        System.out.println(DbUtil.printDbData());
                        printMenu();
                        break;
                    case 2:
                        System.out.print("Enter the radius of the beds:");
                        float radius = (float)readDouble(scanner);
                        FlowerBed flowerBed = new FlowerBed(radius);
                        if (DbUtil.saveToDb(flowerBed) == DbUtil.WRITE_STATUS_OK) {
                            System.out.println("Success added to db:"+flowerBed.getData());
                          } else {
                            System.out.println("Ops... Something went wrong!");
                          }
                        printMenu();
                        break;
                    case 3:
                        System.out.println("Bye bye!");
                        scanner.close();
                        System.exit(0);
                        break;//need ?
                    default:
                        printMenu();
                        break;
                }

            } catch (NumberFormatException e) {
                printMenu();
            }
        } //while
      scanner.close();// need?
    }

}
