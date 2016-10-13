package net.gavrilyuk.solvetasks.minmax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Checked Numbers Class
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class CheckedNumbers {

    private List<Integer> numbers;

    public CheckedNumbers() {
        numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
       this.numbers = numbers;
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int getMin() {
        return Collections.min(numbers);
    }

    public int getMax() {
        return Collections.max(numbers);
    }

    @Override
    public String toString() {
        return "Entered numbers=" + numbers;

    }
}
