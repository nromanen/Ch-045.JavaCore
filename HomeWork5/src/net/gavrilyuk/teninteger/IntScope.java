package net.gavrilyuk.teninteger;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class IntScope {

    private ArrayList<Integer> mValues;

    public IntScope() {
        mValues = new ArrayList<>();
    }

    public ArrayList<Integer> getValues() {
        return mValues;
    }

    public void setValues(ArrayList<Integer> values) {
        mValues = values;
    }

    private boolean checkPositive(int index) {
        if (mValues !=null && mValues.size() >= index) {
            for (int i = 0; i < index; i++) {
                if (mValues.get(i)<0) return false;
            }
        }
        return true;
    }

    public long getSumFirstFivePositive() { //todo fix issue #5
        long res = 0;
        if (checkPositive(5)) {
            for (int i = 0; i < 5; i++) {
                res += mValues.get(i);
            }
            return res;
        } else {
            res = 1;
            for (int i = mValues.size()-1; i > mValues.size() - 5; i--) {
                res *= mValues.get(i);
            }
            return res;
        }

    }

    public void fillData(int count) {
        Random random = new Random(System.currentTimeMillis());
        if(mValues == null) mValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            mValues.add(random.nextInt());
        }
    }

    @Override
    public String toString() {
        return "Values list:" + mValues;
    }
}
