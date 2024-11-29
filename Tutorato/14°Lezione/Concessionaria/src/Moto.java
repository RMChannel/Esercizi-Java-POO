import java.io.Serializable;

public class Moto extends Veicolo implements Serializable {
    private int cilindrata;
    private String tipo;
    public Moto(String marca, String modello, double prezzo, int anno, int cilindrata, String tipo) {
        super(marca, modello, prezzo, anno);
        this.cilindrata = cilindrata;
        this.tipo = tipo;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public double calcolaPrezzoFinale() {
        if(cilindrata<=500) return getPrezzo();
        else if(cilindrata<=1000) return getPrezzo() + (getPrezzo()*5)/100;
        else return getPrezzo() + (getPrezzo()*10)/100;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindrata" + cilindrata + ", Tipo Moto: " + tipo;
    }
}
