package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import Business_logic.Euro;
import Database.BankDatabase;

public class TestBankDatabase {

    BankDatabase Bank;
    Euro EuroAmount;

    @Before
    public void setup() {
        Bank = new BankDatabase();
        EuroAmount = new Euro(1000);
    }

    @Test
    public void testAuthenticateUser() {
        assertTrue("Test AuthenticateUser con user e pin corretto non andato a buon fine!", Bank.authenticateUser(12345, 54321));
        assertTrue("Test AuthenticateUser con pin errato non andato a buon fine!", !Bank.authenticateUser(12345, 123));
        assertTrue("Test AuthenticateUser con user errato non andato a buon fine!", !Bank.authenticateUser(123, 54321));
        assertTrue("Test AuthenticateUser con user e pin errati non andato a buon fine!", !Bank.authenticateUser(123, 321));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, Bank.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, Bank.getTotalBalance(12345).getValore());
    }

    @Test
    public void testCredit() {
        Bank.credit(12345, EuroAmount);
        //Testo solo il totalBalance perche' aumenta solo quella con la credit()
        assertEquals("Test Credit con user 12345 non andato a buon fine", 220000, Bank.getTotalBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        Bank.debit(12345, EuroAmount);
        //Qui testo entrambi perche' diminuiscono entrambi
        assertEquals("Test Debit con user 12345 non andato a buon fine per availableBalance", 0, Bank.getAvailableBalance(12345).getValore());
        //1200 -1000 = 200
        assertEquals("Test Debit con user 12345 non andato a buon fine per totalBalance", 20000, Bank.getTotalBalance(12345).getValore());
    }
}