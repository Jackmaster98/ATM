import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBankDatabase {

    BankDatabase Bank;
    Euro Euro_0;

    @Before
    public void setup() {
         Bank = new BankDatabase();

         Euro_0 = new Euro(1000);
    }
    
    @Test
    public void testAuthenticateUser() {
        assertTrue("AuthenticateUser fallito! [PIN giusto]", Bank.authenticateUser(12345, 54321));
        assertTrue("AuthenticateUser fallito! [PIN sbagliato]", !Bank.authenticateUser(12345, 55555));
        assertTrue("AuthenticateUser fallito! [Utente sbagliato] ", !Bank.authenticateUser(11111, 54321));

    }

    @Test
    public void testCredit() {
        Bank.credit(98765, Euro_0);
        assertEquals(null, 120000, Bank.getTotalBalance(98765).getValore());
    }

    @Test
    public void testDebit() {
        Bank.debit(12345, Euro_0);
        assertEquals(null, 0, Bank.getAvailableBalance(12345).getValore());
        assertEquals(null, 20000, Bank.getTotalBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, Bank.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, Bank.getTotalBalance(12345).getValore());
    }
}
