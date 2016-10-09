package net.gavrilyuk.solvetasks.errorname;

import java.util.Scanner;

/**
 * read number of HTTP Error (400, 401,402, ...)
 * and write the name of this error (Declare enum HTTPError)
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class HTTPErrorsApp {

    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter an HTTPError code [400-500] :");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an HTTPError code [400-500] :");
            }
        }
        return result;
    }
    public static String getName(int code) {
        for (HTTPError httpError : HTTPError.values()) {
            if (httpError.getCode() == code) {
                return httpError.getName();
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = readInt(scanner);
        System.out.println(x+ " HTTPError="+getName(x));
        scanner.close();
    }
}
