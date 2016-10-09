package net.gavrilyuk.solvetasks.errorname;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class HTTPErrorTest {

    @Test
    public void testGetCode() throws Exception {
        assertEquals(400, HTTPError.SC_BAD_REQUEST.getCode());
        assertEquals(404, HTTPError.SC_NOT_FOUND.getCode());
        assertEquals(409, HTTPError.SC_CONFLICT.getCode());
        assertEquals(410, HTTPError.SC_GONE.getCode());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Bad Request", HTTPError.SC_BAD_REQUEST.getName());
        assertEquals("Not Found", HTTPError.SC_NOT_FOUND.getName());
        assertEquals("Conflict", HTTPError.SC_CONFLICT.getName());
        assertEquals("Gone", HTTPError.SC_GONE.getName());
    }


}