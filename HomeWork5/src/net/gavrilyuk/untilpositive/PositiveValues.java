package net.gavrilyuk.untilpositive;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class PositiveValues {

    private AbstractList<Integer> mList;

    public PositiveValues() {
        mList = new ArrayList<>();
    }

    public AbstractList<Integer> getList() {
        return mList;
    }

    public void setList(AbstractList<Integer> list) {
        mList = list;
    }
    public void checkValue(int value) {
        if (mList!=null && value>0) mList.add(value);
    }
    public long getProductions() {
        long res=1;
        if (mList.size() > 0) {
            for (Integer value : mList) {
                if (value%2==0) res *= value;//todo fix issue #7
            }
            return res == 1 ? 0 : res;
        } else return 0;

    }
}
