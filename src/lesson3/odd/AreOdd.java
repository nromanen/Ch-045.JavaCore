package lesson3.odd;

/**
 * Created by Admin on 10.10.16.
 */
public class AreOdd {

    public static boolean odd(int n){
        if (n % 2 == 0){
            return false;
        } else {
            return true;
        }
    }

    public static int howManyOdd(int[] data){

        int result = 0;

        for (Integer i: data){
            if (odd(i)) {
                result ++;
            }
        }
        return result;
    }
}
