import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        CentroSportivo c = new CentroSportivo();
        c.loadFromFiles();
        ArrayList<Utente> utenti = c.getUtenti();
        for(Utente u : utenti) System.out.println(u.toString()+"\n");
        ArrayList<Attivita> attivita = c.getAttivita();
        for(Attivita a : attivita) System.out.println(a.toString()+"\n");
        ArrayList<Prenotazione> prenotazioni = c.getPrenotazioni();
        for(Prenotazione p : prenotazioni) System.out.println(p.toString()+"\n");
    }
}
