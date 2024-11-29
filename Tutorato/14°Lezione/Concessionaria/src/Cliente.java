import java.util.ArrayList;

public class Cliente {
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

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Indirizzo: " + indirizzo;
    }
}
