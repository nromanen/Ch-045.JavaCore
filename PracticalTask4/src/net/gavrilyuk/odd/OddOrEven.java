package net.gavrilyuk.odd;

import java.util.ArrayList;

/**
 * Odd Or Even Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class OddOrEven {

    private ArrayList<Integer> mList;

    public OddOrEven() {
        mList = new ArrayList<>();
    }

    public static boolean isOdd(int number) {
        return number % 2 == 0;
    }

    public void addValue(int value) {
        mList.add(value);
    }

    public ArrayList<Integer> getList() {
        return mList;
    }

    public void setList(ArrayList<Integer> list) {
        mList = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (mList != null ) {
            if (mList.size() > 0) {
                for (Integer value : mList) {
                    if (isOdd(value)) {
                        builder.append(value).append(" is even number.").append("\n");
                    } else builder.append(value).append(" is odd number.").append("\n");

                }
            } else builder.append("list empty!");

        }
        return builder.toString();

    }
}
