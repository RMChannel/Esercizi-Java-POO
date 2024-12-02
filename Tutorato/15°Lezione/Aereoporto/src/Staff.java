import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Staff extends Persona{
    private String ruolo;
    private ArrayList<Turno> turni;
    public Staff(String nome, String cognome, GregorianCalendar datadinascita, int id, String ruolo) {
        super(nome, cognome, datadinascita, id);
        this.ruolo = ruolo;
        turni = new ArrayList<>();
    }
}
