package it.univr.bank;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBankAccount {

    @Test
    public void testEmpty(){
        BankAccount b = new BankAccount();
        assertEquals(0,b.balance());
    }

    @Test
    public void testDeposit(){
        BankAccount b = new BankAccount();
        b.deposit(10);
        assertEquals(10,b.balance());
    }

    @Test
    public void testWithdraw(){
        BankAccount b = new BankAccount();
        // Add 10, withdraw 8, check
        b.deposit(10);
        b.withdraw(8);
        assertEquals(2,b.balance());
    }

    @Test
    public void testCycle(){
        BankAccount b = new BankAccount();
        //Deposit and withdraw 2024 times (for loop) and check the balance
        for(int i = 0;i < 2024; i++){
            b.deposit(10);
            b.withdraw(10);
        }

        assertEquals(0,b.balance());
    }
}
