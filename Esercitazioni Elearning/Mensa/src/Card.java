import java.io.Serializable;

public class Card implements Serializable {
    private int codice;
    private String nome;
    private String cognome;
    private boolean active;

    public Card(int codice, String nome, String cognome, boolean active) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.active = active;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        if(active) throw new RuntimeException("Active card is already active.");
        active = true;
    }

    public void deactivate() {
        if(!active) throw new RuntimeException("Active card is not active.");
        active = false;
    }
}
