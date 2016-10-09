package net.gavrilyuk.tenintegers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegersSource Class
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class IntegersSource {

    private ArrayList<Integer> mList;

    public IntegersSource() {
        mList = new ArrayList<>();
    }

    public ArrayList<Integer> getList() {
        return mList;
    }

    public void setList(ArrayList<Integer> list) {
        if (list != null) {
            mList = list;
        }

    }

    public void addValue(int i) {
        if (mList != null) mList.add(i);
    }

    public int getMax() {
        return Collections.max(mList);
    }

    public long getSumPositive() {
        long result = 0;
        if (mList != null) {
            for (Integer value : mList) {
                if (value > 0) result += value;
            }
        }
        return result;
    }

    public int getNegativeCounts() {
        int result = 0;
        if (mList != null) {
            for (Integer value : mList) {
                if (value < 0) result++;
            }
        }
        return result;
    }

    public String positiveVSNegative() {
        if (mList != null) {
            if (getNegativeCounts() > (mList.size()-getNegativeCounts())) {
                return  "more negative";
            } else if (getNegativeCounts() < (mList.size() - getNegativeCounts())) {
                return  "more positive";
            } else return "equally";
        }
        return "empty list";
    }

    @Override
    public String toString() {
        return "Values list:" +mList;
    }
}
