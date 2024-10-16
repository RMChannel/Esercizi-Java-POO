import java.util.Random;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        BankAccount playerAccount = new BankAccount(1000);
        BankAccount casinoAccount = new BankAccount(100000);
        int predictedValue, actualValue;
        double bet;
        Random r=new Random();
        String choice = "no";
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Inserisci il numero su cui scommettere: ");
            predictedValue=in.nextInt();
            bet=0;
            boolean control=true;
            while(control) {
                System.out.print("Inserisci quanto vuoi scommettere: ");
                bet=in.nextDouble();
                if(bet>playerAccount.getBalance() || (bet*5)>=casinoAccount.getBalance()) {
                    System.out.println("Valore di scommessa non valido, riprovare");
                }
                else control=false;
            }
            actualValue=r.nextInt(1,6);
            if(actualValue==predictedValue) {
                casinoAccount.withdraw(bet*5);
                playerAccount.deposit(bet*5);
                System.out.println("Congratulazioni!!\nHai indovinato, la tua vincita è di: "+bet*5);
            }
            else {
                playerAccount.withdraw(bet);
                casinoAccount.deposit(bet);
                System.out.println("Mi dispiace, hai perso "+bet);
            }
            if(playerAccount.getBalance()>0) {
                System.out.println("Vuoi continuare a giocare?\nInserisci \"si\" per continuare:");
                choice=in.next();
            }
            else {
                choice="no";
            }
        } while(choice.equals("si"));

        System.out.println("Il tuo saldo è " + playerAccount.getBalance());

    }
}