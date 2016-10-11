package lesson3.maxnegative;

import java.util.Arrays;

/**
 * Created by Admin on 10.10.16.
 */
public class MaxNegative {

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
