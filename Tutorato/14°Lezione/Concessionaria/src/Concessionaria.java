import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Concessionaria {
    private ArrayList<Veicolo> veicoli;
    private ArrayList<Cliente> clienti;
    private ArrayList<Ordine> ordini;
    private int ids;
    public Concessionaria() {
        veicoli = new ArrayList<>();
        clienti = new ArrayList<>();
        ordini = new ArrayList<>();
        ids = 0;
    }
    public void addVeicolo(Veicolo veicolo) {
        veicoli.add(veicolo);
    }
    public void addCliente(Cliente cliente) {
        clienti.add(cliente);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public ArrayList<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void addOrdine(Cliente cliente, Veicolo veicolo) {
        if(!veicoli.contains(veicolo)) {
            throw new IllegalArgumentException("Il veicolo non è presente nel concessionario");
        }
        ordini.add(new Ordine(ids,new GregorianCalendar(),cliente,veicolo));
        ids++;
    }
}
