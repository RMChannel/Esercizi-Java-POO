import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        Elicottero elicottero1 = new Elicottero(new GregorianCalendar(2024,11,5),new GregorianCalendar(2024,12,12),30,"Roma","Cito");
        Elicottero elicottero2 = new Elicottero(new GregorianCalendar(2024,11,5),new GregorianCalendar(2024,12,12),30,"Roma","Cito");
        System.out.println(elicottero1.equals(elicottero2));
    }
}
