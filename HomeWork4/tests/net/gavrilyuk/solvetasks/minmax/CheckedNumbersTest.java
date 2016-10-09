package net.gavrilyuk.solvetasks.minmax;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class CheckedNumbersTest {

    CheckedNumbers mCheckedNumbers;

    @Before
    public void initArrayList() {
        mCheckedNumbers = new CheckedNumbers();
    }
    @Test
    public void testConstructor() throws Exception {
        assertNotNull(mCheckedNumbers.getNumbers());
        assertEquals(0, mCheckedNumbers.getNumbers().size());
    }

    @Test
    public void testAddNumber() throws Exception {
        mCheckedNumbers.addNumber(2);
        assertEquals(1, mCheckedNumbers.getNumbers().size());
        mCheckedNumbers.addNumber(-5);
        assertEquals(2, mCheckedNumbers.getNumbers().size());
        mCheckedNumbers.addNumber(0);
        assertEquals(3, mCheckedNumbers.getNumbers().size());
    }

    private void initData() {
        mCheckedNumbers.addNumber(2);
        mCheckedNumbers.addNumber(-5);
        mCheckedNumbers.addNumber(0);
    }
    @Test
    public void testGetMin() throws Exception {
        initData();
        assertEquals(-5, mCheckedNumbers.getMin());
    }

    @Test
    public void testGetMax() throws Exception {
        initData();
        assertEquals(2, mCheckedNumbers.getMax());
    }
}