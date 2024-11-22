package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if(balance < 0) throw new IllegalArgumentException("Il saldo non può essere negativo");
        this.person = person;
        this.balance = balance;
        movements = new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        Movement movement = new Movement(source, amount);
        movements.add(movement);
        balance += amount;
    }

    public void spendFor(int amount, String reason) {
        if (amount > 0) {
            throw new IllegalArgumentException("Il movimento deve essere negativo");
        }
        //Bisogna invertire il segno perché le somme delle spese sono sempre negativi
        if (amount * -1 > balance)
            throw new IllegalArgumentException("Non hai abbastanza denaro");
        this.movements.add(new Movement(reason, amount));
        this.balance += amount;
    }

    public double cashOnHand() {
        return balance;
    }

    public double totalReceivedFrom(String source) {
        double total = 0;
        for (Movement movement : movements) {
            if(movement.getDescription().equalsIgnoreCase(source) && movement.getAmount()>0) {
                total += movement.getAmount();
            }
        }
        return total;
    }

    public double totalSpentFor(String reason) {
        double total = 0;
        for (Movement movement : movements) {
            if(movement.getDescription().equalsIgnoreCase(reason) && movement.getAmount()<0) {
                total += movement.getAmount();
            }
        }
        return total;
    }

    public void printMovements() {
        for (Movement movement : movements) {
            System.out.println("Descrizione: " + movement.getDescription() + "Amount: " + movement.getAmount());
        }
    }

}
