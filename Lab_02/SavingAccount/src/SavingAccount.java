public class SavingAccount {

    private final int accountNumber;
    private static int totalNumberOfAccounts = 0;
    private double balance;
    private double interestRate;

    /**
     * A saving account has a balance that can be changed by deposits and withdrawals.
     */
    public SavingAccount(double interest) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = 0;
        interestRate = interest;
    }

    public SavingAccount(double initialBalance, double interest) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = initialBalance;
        interestRate = interest;
    }

    /**
     * Deposit money to the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
    /**
     * Gets the number of the saving account.
     *
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the saving account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    public void addInterest() {
        balance = balance + ((balance * interestRate * 3)/1200);
    }
}