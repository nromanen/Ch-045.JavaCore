package net.gavrilyuk.solvetasks.checkrange;

import java.util.ArrayList;

/**
 *
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class FloatNumbers {

    private ArrayList<Float> mNumbers;

    public FloatNumbers() {
        mNumbers = new ArrayList<>();
    }

    public ArrayList<Float> getNumbers() {
        return mNumbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        mNumbers = numbers;
    }

    public void addNumber(float number) {
        mNumbers.add(number);
    }

    public boolean isRange(int start, int end) {
        for (Float number : mNumbers) {
            if (number < start || number > end) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entered numbers=" + mNumbers;

    }
}
