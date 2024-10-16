import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    @Before
    public void setup() {
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Dario");
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Dario", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Leqso");
        BankAccount newAccount = b.find(1);
        newAccount.deposit(1000);
        Assert.assertEquals(2000, newAccount.getBalance(), 0);
    }

    @Test
    public void withdrawTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Leqso");
        BankAccount newAccount = b.find(1);
        newAccount.withdraw(1000);
        Assert.assertEquals(0, newAccount.getBalance(), 0);
    }

    @Test
    public void transferTest() {
        Bank b = new Bank();
        b.addAccount(1000, "Leqso");
        b.addAccount(500,"Roberto");
        BankAccount account1=b.find(1);
        BankAccount account2=b.find(2);
        b.transfer(1,2,1000);
        Assert.assertEquals(0, account1.getBalance(), 0);
        Assert.assertEquals(1500, account2.getBalance(), 0);
    }
}