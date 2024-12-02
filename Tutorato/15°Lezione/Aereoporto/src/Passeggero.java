import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Passeggero extends Persona {
    int nPassaporto;
    ArrayList<Biglietto> biglietti;
    public Passeggero(String nome, String cognome, GregorianCalendar datadinascista, int id, int nPassaporto) {
        super(nome,cognome,datadinascista,id);
        this.nPassaporto = nPassaporto;
        biglietti = new ArrayList<>();
    }
}
