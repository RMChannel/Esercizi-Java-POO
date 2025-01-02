package Hotel;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private String cognome;
    private String telefono;
    private String numeroCarta;
    public Cliente(String nome, String cognome, String telefono, String numeroCarta) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.numeroCarta = numeroCarta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    @Override
    public boolean equals(Object c) {
        if(c.getClass().equals(this.getClass())) {
            Cliente cliente = (Cliente) c;
            return this.nome.equals(cliente.nome) && this.cognome.equals(cliente.cognome) && this.telefono.equals(cliente.telefono) && this.numeroCarta.equals(cliente.numeroCarta);
        }
        return false;
    }
}
