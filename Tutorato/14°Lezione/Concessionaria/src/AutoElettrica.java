import java.io.Serializable;

public class AutoElettrica extends Veicolo implements Serializable {
    private int capacità;
    private int autonomia;
    public AutoElettrica(String marca, String modello, double prezzo, int anno, int capacità, int autonomia) {
        super(marca,modello,prezzo,anno);
        this.autonomia = autonomia;
        this.capacità = capacità;
    }

    public int getCapacità() {
        return capacità;
    }

    public int getAutonomia() {
        return autonomia;
    }

    @Override
    public double calcolaPrezzoFinale() {
        return getPrezzo() + (getPrezzo()*10)/100;
    }

    @Override
    public String toString() {
        return super.toString() + " Caratteristiche batteria, Capacità: " + capacità + ", Autonomia: " + autonomia;
    }
}
