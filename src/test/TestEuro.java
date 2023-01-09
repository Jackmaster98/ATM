import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestEuro {

    Euro Euro_0;
    Euro Euro_1;
    Euro Euro_2;
    Euro Euro_3;

    @Before
    public void setup() {
        Euro_0 = new Euro(1);
        Euro_1 = new Euro(1, 50);
        Euro_2 = new Euro(2, 50);
        Euro_3 = new Euro(1, 50);
    }

    @Test
    public void testGetValore() {
        assertEquals(100, Euro_0.getValore());
    }

    @Test
    public void testMinoreDi() {
        assertTrue("MinoreDi fallito! Comparati Euro_1, Euro_0", !Euro_1.minoreDi(Euro_0));
        assertTrue("MinoreDi fallito! Comparati Euro_1, Euro_2", Euro_1.minoreDi(Euro_2));
    }

    @Test
    public void testSomma() {
        assertEquals(250, Euro_0.somma(Euro_1).getValore());
    }

    @Test
    public void testSottrai() {
        assertEquals(150, Euro_2.sottrai(Euro_0).getValore());
    }

    @Test
    public void testStampa() {
        assertEquals("1.5 euro", Euro_1.stampa());
    }

    @Test
    public void testUgualeA() {
        assertTrue("ugualeA fallito! Comparati Euro", Euro_3.ugualeA(Euro_1));
    }
}
