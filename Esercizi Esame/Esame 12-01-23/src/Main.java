import AutoVettura.AutoSpentaException;
import AutoVettura.Elettriche;

public class Main { //SOLO DI TEST
    public static void main(String[] args) throws AutoSpentaException {
        Elettriche tesla=new Elettriche("Tesla",347);
        tesla.start();
        System.out.println(tesla.getTempoGiro(6,12,5));
    }
}