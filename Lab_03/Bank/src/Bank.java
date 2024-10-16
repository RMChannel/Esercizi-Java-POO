import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        BankAccount account=new BankAccount(initialBalance,customerName);
        this.accounts.add(account);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        accounts.get(accountNumber-1).deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        if(accounts.get(accountNumber-1).getBalance()>=amount) accounts.get(accountNumber).withdraw(amount);
        else System.out.println("Insufficient balance");
    }

    public double getBalance(int accountNumber) {
        return accounts.get(accountNumber-1).getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        System.out.println("aaaa"+accounts.get(fromAccountNumber).getBalance());
        if(accounts.get(fromAccountNumber-1).getBalance()>=amount) {
            accounts.get(fromAccountNumber-1).withdraw(amount);
            accounts.get(toAccountNumber-1).deposit(amount);
        }
        else System.out.println("Insufficient balance");
    }
}