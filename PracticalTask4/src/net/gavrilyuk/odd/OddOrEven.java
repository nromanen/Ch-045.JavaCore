package net.gavrilyuk.odd;

import java.util.ArrayList;
import java.util.List;

/**
 * Odd Or Even Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class OddOrEven {

    private List<Integer> list;

    public OddOrEven() {
        list = new ArrayList<>();
    }

    public static boolean isOdd(int number) {
        return number % 2 == 0;
    }

    public void addValue(int value) {
        list.add(value);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (list != null ) {
            if (list.size() > 0) {
                for (Integer value : list) {
                    if (isOdd(value)) {
                        builder.append(value).append(" is even number.").append("\n");
                    } else builder.append(value).append(" is odd number.").append("\n");

                }
            } else builder.append("list empty!");

        }
        return builder.toString();

    }
}
