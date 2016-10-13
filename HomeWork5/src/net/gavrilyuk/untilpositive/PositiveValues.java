package net.gavrilyuk.untilpositive;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class PositiveValues {

    private List<Integer> list;

    public PositiveValues() {
        list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(AbstractList<Integer> list) {
        this.list = list;
    }
    public void checkValue(int value) {
        if (list !=null && value>0) list.add(value);
    }
    public long getProductions() {
        long res=1;
        if (list != null && list.size() > 0) {
            for (Integer value : list) {
                if (value % 2 == 0) res *= value;//todo fix issue #7
            }
            return res == 1 ? 0 : res;
        } else return 0;

    }
}
