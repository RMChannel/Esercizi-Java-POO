import java.util.GregorianCalendar;

public abstract class Persona {
    private String nome;
    private String cognome;
    private GregorianCalendar dataNascita;
    private int id;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public GregorianCalendar getDataNascita() {
        return dataNascita;
    }

    public int getId() {
        return id;
    }

    public Persona(String nome, String cognome, GregorianCalendar dataNascita, int id) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.id = id;
    }
}
