package net.gavrilyuk.tenintegers;

import java.util.Random;

/**
 * Create an array of ten integers. Display 
 *the biggest of these numbers;
 *the sum of positive numbers in the array;
 *the amount of negative numbers in the array.
 *  What values there are more: negative or positive?
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class TenIntegersTask {


    private static final int INT_COUNT = 10;

    private static void fillIntegerList(IntegersSource source) {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < INT_COUNT; i++) {
            source.addValue(r.nextInt());
        }
    }

    public static void main(String[] args) {
        IntegersSource source = new IntegersSource();
        fillIntegerList(source);
        System.out.println(source.toString());
        System.out.println("Max=" + source.getMax());
        System.out.println("Positive sum="+source.getSumPositive());
        System.out.println("Negative count="+source.getNegativeCounts());
        System.out.println("Positive VS Negative:"+source.positiveVSNegative());
    }
}
