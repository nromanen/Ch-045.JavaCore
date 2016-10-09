package net.gavrilyuk.solvetasks.checkrange;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class FloatNumbersTest {


    FloatNumbers numbers;

    @Before
    public void initArrayList() {
        numbers = new FloatNumbers();
    }

    @Test
    public void testConstructor() throws Exception {
        assertNotNull(numbers.getNumbers());
        assertEquals(0, numbers.getNumbers().size());
    }

    @Test
    public void testAddNumber() throws Exception {
        numbers.addNumber(5);
        assertEquals(1, numbers.getNumbers().size());
        numbers.addNumber(-5);
        assertEquals(2, numbers.getNumbers().size());
        numbers.addNumber(0);
        assertEquals(3, numbers.getNumbers().size());
    }

    @Test
    public void testIsRange() throws Exception {
        assertEquals("all belong to the range [-5,5]:", true, numbers.isRange(-5, 5));
        numbers.getNumbers().clear();
        numbers.addNumber(6);
        numbers.addNumber(-9);
        numbers.addNumber(2);
        assertEquals("all belong to the range [-5,5]:", false, numbers.isRange(-5, 5));
    }

}