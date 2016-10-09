package net.gavrilyuk.kennel;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Dog Test
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class DogTest {


    @Test
    public void testGetName() throws Exception {
        Dog mDog = new Dog();
        assertEquals("unknown", mDog.getName());
        mDog = new Dog("Tuzik");
        assertEquals("Tuzik", mDog.getName());
    }

    @Test
    public void testEquals() throws Exception {
        Dog dog1 =  new Dog("Barsik");
        Dog dog2 =  new Dog("Barsik");
        assertTrue(dog1.equals(dog2));
        dog2.setName("Sharik");
        assertFalse(dog1.equals(dog2));
    }
}