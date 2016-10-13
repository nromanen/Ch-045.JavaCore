package net.gavrilyuk.fivenumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class NumbersScope {

    private List<Integer> values;

    public NumbersScope() {
        values = new ArrayList<>();
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
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
        if (values != null) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i)>0) {
                    count++;
                    if (count==2) return i;
                }
            }
        }

        return res;
    }

    public int getMinPosition(int min) {
        return values.indexOf(min);
    }

    public int getMin() {
        return Collections.min(values);
    }

    public String getMinAndPosition() {
        return "Min="+getMin() +" Position="+getMinPosition(getMin());
    }

    public void addValue(int value) {
        if (values !=null) values.add(value);
    }

    @Override
    public String toString() {
        return  "Values=" + values;

    }
}
