package Hotel;

import java.io.Serializable;
import java.util.Objects;

public class Stanza implements Serializable {
    private int numero;
    private int piano;
    private int tipologia;
    private String servizi;
    private String telefono;

    public Stanza(int numero, int piano, int tipologia, String servizi, String telefono) {
        this.numero = numero;
        this.piano = piano;
        this.tipologia = tipologia;
        this.servizi = servizi;
        this.telefono = telefono;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiano() {
        return piano;
    }

    public int getTipologia() {
        return tipologia;
    }

    public String getServizi() {
        return servizi;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stanza stanza = (Stanza) o;
        return numero == stanza.numero && piano == stanza.piano && tipologia == stanza.tipologia && Objects.equals(servizi, stanza.servizi) && Objects.equals(telefono, stanza.telefono);
    }
}
