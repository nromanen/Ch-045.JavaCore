package net.gavrilyuk.teninteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class IntScope {

    private List<Integer> values;

    public IntScope() {
        values = new ArrayList<>();
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    private boolean checkPositive(int index) {
        if (values != null && values.size() >= index) {
            for (int i = 0; i < index; i++) {
                if (values.get(i) < 0) return false;
            }
        }
        return true;
    }

    public long getSumFirstFivePositive() { //todo fix issue #5
        long res = 0;
        if (checkPositive(5)) {
            for (int i = 0; i < 5; i++) {
                res += values.get(i);
            }
            return res;
        } else {
            res = 1;
            for (int i = values.size()-1; i > values.size() - 5; i--) {
                res *= values.get(i);
            }
            return res;
        }

    }

    public void fillData(int count) {
        Random random = new Random(System.currentTimeMillis());
        if(values == null) values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(random.nextInt());
        }
    }

    @Override
    public String toString() {
        return "Values list:" + values;
    }
}
