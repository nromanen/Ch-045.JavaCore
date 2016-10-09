package net.gavrilyuk.kennel;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class BreedTest {

    @Test
    public void testGetKind() throws Exception {
        assertEquals("St. Bernard", Breed.ST_BERNAR.getKind());

    }

    @Test
    public void testSetKind() throws Exception {
        Breed.ST_BERNAR.setKind("Test");
        assertEquals("Test", Breed.ST_BERNAR.getKind());
    }
}