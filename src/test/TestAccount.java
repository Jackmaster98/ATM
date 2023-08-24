package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import Business_logic.Account;
import Business_logic.Euro;

public class TestAccount {

    Account Account1;
    Account Account2;
    Account Account3;

    Euro Euro_0;

    @Before
    public void setup() {
        Account1 = new Account(123, 321, new Euro(1000), new Euro(1500));
        Account2 = new Account(1234, 4321, new Euro(2000), new Euro(2500));
        Account3 = new Account(12345, 54321, new Euro(3000), new Euro(3500));
    }

    @Test
    public void testValidatePIN() {
        assertTrue("Test ValidatePIN con pin corretto fallito!", Account1.validatePIN(321));
        assertTrue("Test ValidatePIN con pin errato fallito!", !Account2.validatePIN(123));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(200000, Account2.getAvailableBalance().getValore());
    }

        @Test
    public void testGetTotalBalance() {
        assertEquals(250000, Account2.getTotalBalance().getValore());
    }

    @Test
    public void testCredit() {
        Account1.credit(new Euro(1000));
        assertEquals(250000, Account1.getTotalBalance().getValore()); 
    }

    @Test
    public void testDebit() {
        Account2.debit(new Euro(1000));
        assertEquals(100000, Account2.getAvailableBalance().getValore()); 
        assertEquals(150000, Account2.getTotalBalance().getValore()); 
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(12345, Account3.getAccountNumber()); 
    }


}