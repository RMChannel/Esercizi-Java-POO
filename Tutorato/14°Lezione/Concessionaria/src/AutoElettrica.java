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

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(AutoElettrica.class)) {
            AutoElettrica autoElettrica = (AutoElettrica) obj;
            Veicolo veicolo = (Veicolo) obj;
            return autoElettrica.capacità==this.capacità && autoElettrica.autonomia==this.autonomia && super.equals(veicolo);
        }
        return false;
    }
}
