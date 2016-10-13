package net.gavrilyuk.solvetasks.checkrange;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class FloatNumbers {

    private List<Float> numbers;

    public FloatNumbers() {
        numbers = new ArrayList<>();
    }

    public List<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Float> numbers) {
        this.numbers = numbers;
    }

    public void addNumber(float number) {
        numbers.add(number);
    }

    public boolean isRange(int start, int end) {
        if (numbers != null) {
            for (Float number : numbers) {
                if (number < start || number > end) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entered numbers=" + numbers;

    }
}
