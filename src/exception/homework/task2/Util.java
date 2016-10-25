package exception.homework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Method read integer number, check is it number in range [begin, end] and return it
    public static int readNumber(int begin, int end) throws IOException, IncorrectIntegerException, NumberFormatException {

        int t = 0;
        try {
            t = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }

        if (t <= begin || t >= end){
            throw new IncorrectIntegerException(begin, end);
        }
        return t;
    }
}
