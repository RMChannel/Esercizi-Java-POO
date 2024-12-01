import java.io.Serializable;

public abstract class Veicolo implements Serializable, Comparable<Veicolo> {
    private String marca;
    private String modello;
    private double prezzo;
    private int anno;

    public Veicolo() {
        marca = "";
        modello = "";
        prezzo = 0;
        anno = 0;
    }

    public Veicolo(String marca, String modello, double prezzo, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.anno = anno;
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Prezzo: " + prezzo + ", Anno: " + anno;
    }

    public abstract double calcolaPrezzoFinale();

    public Veicolo getSuper() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Veicolo v = (Veicolo) obj;
            return v.anno == this.anno && v.marca.equals(this.marca) && v.modello.equals(this.modello) && v.prezzo == this.prezzo;
        }
        return false;
    }

    @Override
    public int compareTo(Veicolo o) {
        return o.getMarca().compareTo(this.marca)*-1;
    }
}
