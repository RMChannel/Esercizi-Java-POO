package it.unisa.bank;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account = this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = this.find(fromAccountNumber);
        BankAccount toAccount = this.find(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        accounts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll(" ","");
            String[] split = line.split(",");
            int accountNumber = Integer.parseInt(split[0]);
            String name = split[1];
            double amount = Double.parseDouble(split[2]);
            if(split.length==4) {
                double interestRate=Double.parseDouble(split[3]);
                accounts.add(new SavingAccount(accountNumber, name, amount, interestRate));
            }
            else {
                accounts.add(new BankAccount(accountNumber, name, amount));
            }
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(overwrite) {
            String path = file.getAbsolutePath();
            file.delete();
            file = new File(path);
        }
        else {
            if(!file.exists()) {
                throw new FileAlreadyExistsException("Il file già esiste");
            }
        }
        try {
            writeUserDataToFile(file);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for(BankAccount account : this.accounts) {
            if(account instanceof SavingAccount) {
                printWriter.println(account.getAccountNumber()+", "+account.getCustomerName()+", "+account.getBalance()+", "+((SavingAccount) account).getInterestRate());
            }
            else {
                printWriter.println(account.getAccountNumber()+", "+account.getCustomerName()+", "+account.getBalance());
            }
        }
        printWriter.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        accounts = new ArrayList<>();
        while (true) {
            try {
                BankAccount account = (BankAccount) in.readObject();
                this.accounts.add(account);
            }
            catch (EOFException e) {
                break;
            }
        }
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (BankAccount account : this.accounts) {
            out.writeObject(account);
        }
    }
}