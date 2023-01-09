import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestAccount {

    Account Account_0;
    Account Account_1;
    Account Account_2;

    Euro Euro_0;


    @Before
    public void setup() {
        Account_0 = new Account(0, 0, new Euro(1000), new Euro(1100));
        Account_1 = new Account(1, 1, new Euro(2000), new Euro(2100));
        Account_2 = new Account(2, 2, new Euro(3000), new Euro(3100));
        Euro_0 = new Euro(1000);
    }

    @Test
    public void testCredit() {
        Account_0.credit(Euro_0);
        assertEquals(210000, Account_0.getTotalBalance().getValore()); // 2100 Euro
    }

    @Test
    public void testDebit() {
        Account_1.debit(Euro_0);
        assertEquals(100000, Account_1.getAvailableBalance().getValore()); // 1000 Euro
        assertEquals(110000, Account_1.getTotalBalance().getValore()); // 1100 Euro
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(2, Account_2.getAccountNumber()); // 1000 Euro
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(200000, Account_1.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(210000, Account_1.getTotalBalance().getValore());
    }

    @Test
    public void testValidatePIN() {
        assertTrue("ValidatePIN fallito!", Account_0.validatePIN(0));
        assertTrue("ValidatePIN fallito!", !Account_1.validatePIN(0));
    }
}
