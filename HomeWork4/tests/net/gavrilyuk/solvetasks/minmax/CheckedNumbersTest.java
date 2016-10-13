package net.gavrilyuk.solvetasks.minmax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class CheckedNumbersTest {

    CheckedNumbers checkedNumbers;

    @Before
    public void initArrayList() {
        checkedNumbers = new CheckedNumbers();
    }
    @Test
    public void testConstructor() throws Exception {
        assertNotNull(checkedNumbers.getNumbers());
        assertEquals(0, checkedNumbers.getNumbers().size());
    }

    @Test
    public void testAddNumber() throws Exception {
        checkedNumbers.addNumber(2);
        assertEquals(1, checkedNumbers.getNumbers().size());
        checkedNumbers.addNumber(-5);
        assertEquals(2, checkedNumbers.getNumbers().size());
        checkedNumbers.addNumber(0);
        assertEquals(3, checkedNumbers.getNumbers().size());
    }

    private void initData() {
        checkedNumbers.addNumber(2);
        checkedNumbers.addNumber(-5);
        checkedNumbers.addNumber(0);
    }
    @Test
    public void testGetMin() throws Exception {
        initData();
        assertEquals(-5, checkedNumbers.getMin());
    }

    @Test
    public void testGetMax() throws Exception {
        initData();
        assertEquals(2, checkedNumbers.getMax());
    }
}