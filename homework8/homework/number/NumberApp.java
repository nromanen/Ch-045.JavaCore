package homework8.homework.number;

/**
 * Created by roma on 31.10.2016.
 * Write a method readNumber(int start, int end), that read from console integer number
 * and return it, if it is in the range [start...end].
 If an invalid number or non-number text is read, the method should throw an exception.
 Using this method write a method main(), that has to enter 10 numbers:
 a1, a2, ..., a10, such that 1 < a1 < ... < a10 < 100

 */
public class NumberApp {

    final static int count = 10;
    final static int startRange = -10;
    final static int endRange = 20;

    public static void main(String[] args){

        for (int i=0; i<count; i++){
            NumberUtils.readIntVal(startRange, endRange);
        }
    }
}
