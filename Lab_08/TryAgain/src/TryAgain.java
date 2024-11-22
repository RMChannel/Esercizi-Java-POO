import java.util.*;

public class TryAgain {

    public static int inInt(Scanner in, int tries) {
        try {
            return in.nextInt();
        }
        catch(InputMismatchException exception) {
            if(tries==1) throw new InputMismatchException("Troppi tentativi falliti");
            System.out.println("Il dato inserito non era un numero, riprovare: ");
            in.next();
            return inInt(in, tries+1);
        }
    }

    public static double inDouble(Scanner in, int tries) {
        try {
            return in.nextDouble();
        }
        catch(InputMismatchException exception) {
            if(tries==1) throw new InputMismatchException("Troppi tentativi falliti");
            System.out.println("Il dato inserito non era un numero, riprovare: ");
            in.next();
            return inInt(in, tries+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        System.out.print("Inserisci il numero di numeri double da inserire: ");
        int n=inInt(in, 0);
        for(int i=1; i<=n; i++) {
            System.out.print("Inserisci il "+i+"° double da inserire: ");
            sum += inDouble(in, 0);
        }
        System.out.println("Il totale dei valori inseriti è " + sum);
    }
}