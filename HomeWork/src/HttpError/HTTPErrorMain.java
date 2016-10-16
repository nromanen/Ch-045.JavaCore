package HttpError;

import java.io.IOError;
import java.util.Scanner;

/**
 * Created by evil on 12.10.16.
 */
public class HTTPErrorMain {
    private static int readNumber (){
        int num = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("Print HTTP status");
        try {
            while (num<0){
                System.out.println("Invalid data");
                num = in.nextInt();
            }
            } catch (IOError e){
            System.out.println("Some problems " + e.getMessage());
        }
        return num;
    }

    public static void main(String[] args) {
        HTTPStatus error = new HTTPStatus();
        error.findHttpStatus(readNumber());
        System.out.println(error.toString());
    }
}
