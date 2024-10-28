import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ContoCorrente c=new ContoCorrente("Roberto","Cito",5000);
        try {
            c.preleva(4000);
            System.out.println(c.restituisciSaldo());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            c.preleva(2000);
            System.out.println(c.restituisciSaldo());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}