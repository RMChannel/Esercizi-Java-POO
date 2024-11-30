import java.lang.reflect.InvocationTargetException;
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

    public void addOrdine(Ordine ordine) {
        ordini.add(ordine);
        ordine.getCliente().addOrdine(ordine);
    }

    public boolean removeVeicolo(Veicolo veicolo) {
        for(Ordine ordine : ordini) {
            if(ordine.getVeicolo().equals(veicolo)) {
                return false;
            }
        }
        veicoli.remove(veicolo);
        return true;
    }

    public boolean removeCliente(Cliente cliente) {
        for(Ordine ordine : ordini) {
            if(ordine.getCliente().equals(cliente)) {
                return false;
            }
        }
        clienti.remove(cliente);
        return true;
    }

    public void removeOrdine(Ordine ordine) {
        ordine.getCliente().removeOrdine(ordine);
        ordini.remove(ordine);
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
        if(veicoloIsOrdinato(veicolo)) {
            throw new IllegalCallerException("Il veicolo è già stato ordinato");
        }
        ordini.add(new Ordine(ids,new GregorianCalendar(),cliente,veicolo));
        ids++;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public boolean veicoloIsOrdinato(Veicolo veicolo) {
        for(Ordine ord : ordini) {
            if(ord.getVeicolo().equals(veicolo)) return true;
        }
        return false;
    }
}
