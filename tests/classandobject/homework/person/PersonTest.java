package classandobject.homework.person;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.10.16.
 */
public class PersonTest {

    private Person person = new Person("Vasya", 2000, 5, 13);

//    @Test
//    public void testGetBirthDay() throws Exception {
//
//    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Vasya", person.getName());
    }

    @Test
    public void testAge() throws Exception {
        assertEquals((new GregorianCalendar()).get(Calendar.YEAR)-2000, person.age());
    }

//    @Test
//    public void testInput() throws Exception {
//
//    }
//
//    @Test
//    public void testOutput() throws Exception {
//
//    }
//
//    @Test
//    public void testToString() throws Exception {
//
//    }
}