package homework3.practical;

/**
 * Created by roma on 12.10.2016.
 *
 * Enter some numbers. Find out how many of them are odd
 */
public class OddNumber {
    public static void main(String[] args){

        int [] array = {12,45,-6,89,78,56,-4,7,532,6,-66,44,-12,8,5,77};

        System.out.println("Count odd number in array: "+OddNumber.countOdd(array));
    }

    public static int countOdd(int [] number){
        int count = 0;
        if (number.length != 0){
            for (int i=0; i<number.length; i++){
                if (number[i] % 2 == 0){ count++; }
            }
        } else {
            return 0;
        }
        return count;
    }
}
