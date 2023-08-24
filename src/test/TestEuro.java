package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Business_logic.Euro;

public class TestEuro {

    Euro Euro1;
    Euro Euro2;
    Euro Euro3;
    Euro Euro4;

    @Before
    public void setup() {
        Euro1 = new Euro(1);
        Euro2 = new Euro(2);
        Euro3 = new Euro(2, 50);
        Euro4 = new Euro(1);
    }

    @Test
    public void testGetValore() {
        assertEquals(100, Euro1.getValore());
    }

    @Test
    public void testSomma() {
        //Controllo che 1 + 2 sia = 3
        assertEquals(300, Euro1.somma(Euro2).getValore());
    }

    @Test
    public void testSottrai() {
        //Controllo che 2,5 - 1 sia = 1,5
        assertEquals(150, Euro3.sottrai(Euro1).getValore());
    }

    @Test
    public void testUgualeA() {
        assertTrue("Test ugualeA non andato a buon fine!", Euro1.ugualeA(Euro4));
    }

    @Test
    public void testMinoreDi() {
        assertTrue("Test MinoreDi non andato a buon fine!", Euro2.minoreDi(Euro3));
    }

    @Test
    public void testStampa() {
        assertEquals("2.5 euro", Euro3.stampa());
    }

}