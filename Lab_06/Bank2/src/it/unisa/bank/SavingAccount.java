package it.unisa.bank;

public class SavingAccount extends BankAccount {

    private double interestRate;

    /**
     * A saving account has a balance that can be changed by deposits and withdrawals.
     */
    public SavingAccount(String customerName, double interestRate) {
        super(customerName);
        this.interestRate = interestRate;
    }

    public SavingAccount(String customerName, double initialBalance, double interestRate) {
        super(customerName, initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * Add the interest rate for three months
     */
    public void addInterest() {
          super.deposit((super.getBalance() * interestRate * 3)/1200);
    }

    /**
     * Gets the interest rate of the saving account.
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate of the saving account.
     *
     * @param interestRate the interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}