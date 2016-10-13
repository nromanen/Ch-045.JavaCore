package net.gavrilyuk.employee;

import net.gavrilyuk.employees.TariffRates;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * Created by Igor Gavryliuk on 13.10.2016.
 */
public class TariffRatesTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetTariffName() {
        assertEquals("Tariff 1", TariffRates.TARIFF_1.getTariffName());
        assertEquals("Tariff 2",TariffRates.TARIFF_2.getTariffName());
        assertEquals("Tariff 3",TariffRates.TARIFF_3.getTariffName());
    }

    @Test
    public void testGetTariffValue() {
        assertEquals(5000,TariffRates.TARIFF_1.getTariffValue(),0.01);
        assertEquals(7000,TariffRates.TARIFF_2.getTariffValue(),0.01);
        assertEquals(9000,TariffRates.TARIFF_3.getTariffValue(),0.01);
    }
    @Test
    public void testSetTariffName() throws IllegalArgumentException {
        //test type
        thrown.expect(IllegalArgumentException.class);
        //test message
        thrown.expectMessage(is("Tariff name should not be empty!"));
        TariffRates.TARIFF_1.setTariffName(null);
        TariffRates.TARIFF_2.setTariffName("");
        TariffRates.TARIFF_3.setTariffName("  ");
    }

    @Test
    public void testSetTariffValue() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(containsString("Tariff cannot be "));
        TariffRates.TARIFF_1.setTariffValue(-1.1f);
    }
}