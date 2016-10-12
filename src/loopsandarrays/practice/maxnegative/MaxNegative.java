package loopsandarrays.practice.maxnegative;

import java.util.Arrays;


public class MaxNegative {

    // Method return max negative numbers of the array
    public static int getMaxNegative(int ... data){

        Arrays.sort(data);

        int result = 0;

        if (data[0]>=0){
            return result;
        } else {
            result = data[0];
        }

        for (Integer i : data){
            if (i >= 0){
                break;
            } else {
                result = i;
            }
        }
        return result;

    }
}
