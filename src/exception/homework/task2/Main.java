package exception.homework.task2;

import java.io.IOException;

import static util.Print.print;
import static util.Print.println;

/* Write a method readNumber(int start, int end), that read from console integer number and return it,
 * if it is in the range [start...end].
 * If an invalid number or non-number text is read, the method should throw an exception.
 * Using this method write a method main(), that has to enter 10 numbers:
 * a1, a2, ..., a10, such that 1 < a1 < ... < a10 < 100
 */
public class Main {
    public static void main(String[] args) {

        int n = 10;

        int intArr[] = new int[10];

        int begin = 1;
        int end = 100;
        for (int i = 0; i < n; ) {
            if(begin == (end - 1)){
                break;
            }
            try {
                intArr[i] = Util.readNumber(begin, end);
            }
            catch (IOException e) {
                println("IOException");
                continue;
            } catch (NumberFormatException e){
                println("NumberFormatException");
                continue;
            } catch (IncorrectIntegerException e) {
                println("IncorrectIntegerException");
                continue;
            }
            begin = intArr[i++];

        }

        for (int i : intArr) {
            print(i + " ");
        }

        try {
            Util.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
