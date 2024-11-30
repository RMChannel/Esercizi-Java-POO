import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String nome;
    private String cognome;
    private String indirizzo;
    private ArrayList<Ordine> ordini;
    public Cliente(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.ordini = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public void addOrdine(Ordine ordine){
        this.ordini.add(ordine);
    }

    public void removeOrdine(Ordine ordine){
        this.ordini.remove(ordine);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Indirizzo: " + indirizzo;
    }
}
