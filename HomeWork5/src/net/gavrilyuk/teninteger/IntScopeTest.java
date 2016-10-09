package net.gavrilyuk.teninteger;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class IntScopeTest {


    private ArrayList<Integer> fillData(int val) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(val);
        }
        return res;
    }

    @Test
    public void testGetSumFirstFivePositive() throws Exception {
        IntScope scope = new IntScope();
        scope.setValues(fillData(2));
        assertEquals("Sum=10", scope.getSumFirstFivePositive());
        scope.setValues(fillData(-2));
        assertEquals("Prod=16", scope.getSumFirstFivePositive());
    }
}