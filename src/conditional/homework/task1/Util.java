package conditional.homework.task1;


public class Util {

    // Method check are float numbers in range [min, max]
    public static boolean inRange(int min, int max, float... data){

        if (max < min) {
            return false;
        }

        boolean isInRange = true;

        for (Float f: data){
            if(f >= min && f <= max){
                continue;
            } else {
                isInRange = false;
            }
        }

        return isInRange;
    }

    //Method return max number of the entered numbers
    public static int maxOfThreInt(int a, int b, int c){
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max){
            max = c;
        }
        return max;
    }
}
