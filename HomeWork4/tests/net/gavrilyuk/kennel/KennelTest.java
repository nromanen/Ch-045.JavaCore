package net.gavrilyuk.kennel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class KennelTest {

    Kennel mKennel;

    public void fillKennel() {
        Dog dog1 = new Dog("Tusik",Breed.WITH_OUT_BREED,1);
        mKennel.addDog(dog1);
        Dog dog2 = new Dog("Belka",Breed.ENGLISH_MASTIFF,5);
        mKennel.addDog(dog2);
        Dog dog3 = new Dog("Strelka",Breed.KOMONDOR,10);
        mKennel.addDog(dog3);
        Dog dog4 = new Dog("Strelka",Breed.ST_BERNAR,2);
        mKennel.addDog(dog4);
    }

    @Before
    public void setUp() throws Exception {
        mKennel = new Kennel();
    }


    @Test
    public void testAddDog() throws Exception {
            Dog dog =new Dog();
            mKennel.addDog(dog);
            assertEquals(1, mKennel.getDogs().size());
            assertEquals("unknown", mKennel.getDogs().get(0).getName());
    }

    @Test
    public void testCheckDogsSameName() throws Exception {
         fillKennel();
         assertEquals(true, mKennel.checkDogsSameName());
    }

    @Test
    public void testGetOldestDog() throws Exception {
        fillKennel();
        assertEquals(new Dog("Strelka", Breed.KOMONDOR, 10), mKennel.getOldestDog());
    }
}