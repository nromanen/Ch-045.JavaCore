package net.gavrilyuk.teninteger;


/**
 * Enter 10 integer numbers.
 * Calculate the sum of first 5 elements if they are positive or product of last 5 element in the other case.
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class TenIntegerApp {

    public static void main(String[] args) {
        IntScope scope = new IntScope();
        scope.fillData(10);
        System.out.println(scope.toString());
        System.out.println(scope.getSumFirstFivePositive());

    }
}
