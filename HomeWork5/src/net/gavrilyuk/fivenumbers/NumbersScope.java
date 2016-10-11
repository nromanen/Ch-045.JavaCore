package net.gavrilyuk.fivenumbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class NumbersScope {

    private ArrayList<Integer> mValues;

    public NumbersScope() {
        mValues = new ArrayList<>();
    }

    public ArrayList<Integer> getValues() {
        return mValues;
    }

    public void setValues(ArrayList<Integer> values) {
        mValues = values;
    }

    //todo fix issue #6
   /* public String getPosSecondPositive(int pos) {
        if (pos != -1) {
            return "Position ="+pos;
        } else return "No second positive present";

    }*/

    //return second positive position or -1 on not present
    public int findPosSecondPositive() {
        int res = -1;
        int count = 0;
        for (int i = 0; i < mValues.size(); i++) {
            if (mValues.get(i)>0) {
                count++;
                if (count==2) return i;
            }
        }
        return res;
    }

    public int getMinPosition(int min) {
        return mValues.indexOf(min);
    }

    public int getMin() {
        return Collections.min(mValues);
    }

    public String getMinAndPosition() {
        return "Min="+getMin() +" Position="+getMinPosition(getMin());
    }

    public void addValue(int value) {
        if (mValues!=null) mValues.add(value);
    }

    @Override
    public String toString() {
        return  "Values=" + mValues ;

    }
}
