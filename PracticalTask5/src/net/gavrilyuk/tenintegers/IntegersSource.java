package net.gavrilyuk.tenintegers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Integers Source Class
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class IntegersSource {

    private List<Integer> list;

    public IntegersSource() {
        list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        if (list != null) {
            this.list = list;
        }

    }

    public void addValue(int i) {
        if (list != null) list.add(i);
    }

    public int getMax() {
        return Collections.max(list);
    }

    public long getSumPositive() {
        long result = 0;
        if (list != null) {
            for (Integer value : list) {
                if (value > 0) result += value;
            }
        }
        return result;
    }

    public int getNegativeCounts() {
        int result = 0;
        if (list != null) {
            for (Integer value : list) {
                if (value < 0) result++;
            }
        }
        return result;
    }

    public String positiveVSNegative() {
        if (list != null) {
            if (getNegativeCounts() > (list.size()-getNegativeCounts())) {
                return  "more negative";
            } else if (getNegativeCounts() < (list.size() - getNegativeCounts())) {
                return  "more positive";
            } else return "equally";
        }
        return "empty list";
    }

    @Override
    public String toString() {
        return "Values list:" + list;
    }
}
