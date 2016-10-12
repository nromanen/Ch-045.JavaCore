package conditional.practice.odd;

public class Odd {

    // Method check is the number odd
    public static boolean isOdd(int n){
        if (n % 2 == 0){
            return false;
        } else {
            return true;
        }
    }

    // Method calculates how many odd numbers are in array
    public static int howManyOdd(int[] data){

        int result = 0;

        for (Integer i: data){
            if (isOdd(i)) {
                result ++;
            }
        }
        return result;
    }
}
