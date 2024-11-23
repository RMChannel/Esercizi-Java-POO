import java.util.ArrayList;

public class Attivita {
    private String nome;
    private int available;
    public Attivita(String nome, int available) {
        this.nome = nome;
        this.available = available;
    }
    public String getNome() {
        return nome;
    }
    public int getAvailable() {
        return available;
    }
    public boolean prenotaPosto()  {
        if(available == 0) {
           return false;
        }
        else {
            available--;
            return true;
        }
    }

    public void ripristinaPosto() {
        available++;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Attivita.class)) {
            Attivita attivita = (Attivita) obj;
            return nome.equals(attivita.nome) && available == attivita.available;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+"      posti disponibili: "+available;
    }

    public String toStringForFile() {
        return nome + " " + available;
    }
}
