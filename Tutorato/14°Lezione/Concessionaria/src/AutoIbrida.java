import java.io.Serializable;
import java.util.GregorianCalendar;

public class AutoIbrida extends Veicolo implements Serializable {
    private double consumoMedio;
    private String tipo;
    public AutoIbrida(String marca, String modelo, double prezzo, int anno, double consumoMedio, String tipo) {
        super(marca, modelo, prezzo, anno);
        this.consumoMedio = consumoMedio;
        this.tipo = tipo;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public double calcolaPrezzoFinale() {
        GregorianCalendar gc = new GregorianCalendar();
        double prezzo = getPrezzo();
        if(getAnno() >= gc.getWeekYear()-3) prezzo = prezzo - (prezzo * 3)/100;
        if(consumoMedio<4) {
            return prezzo - (prezzo*4)/100;
        }
        else if(consumoMedio<6) {
            return prezzo;
        }
        else {
            return prezzo + (prezzo*7)/100;
        }
    }

    @Override
    public String toString() {
        return super.toString()+ " Tipo: " + getTipo() + ", Consumo medio: " + getConsumoMedio();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(AutoIbrida.class)) {
            AutoIbrida other = (AutoIbrida) obj;
            Veicolo v = (Veicolo) obj;
            return other.consumoMedio==this.consumoMedio && other.tipo.equals(this.tipo) && super.equals(v);
        }
        return false;
    }
}
