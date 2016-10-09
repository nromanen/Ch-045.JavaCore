package net.gavrilyuk.solvetasks.minmax;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Checked Numbers Class
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class CheckedNumbers {

    private ArrayList<Integer> mNumbers;

    public CheckedNumbers() {
        mNumbers = new ArrayList<>();
    }

    public ArrayList<Integer> getNumbers() {
        return mNumbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        mNumbers = numbers;
    }
    public void addNumber(int number) {
        mNumbers.add(number);
    }

    public int getMin() {
        return Collections.min(mNumbers);
    }

    public int getMax() {
        return Collections.max(mNumbers);
    }

    @Override
    public String toString() {
        return "Entered numbers=" + mNumbers;

    }
}
