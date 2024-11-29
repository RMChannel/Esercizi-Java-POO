public abstract class Veicolo {
    private String marca;
    private String modello;
    private double prezzo;
    private int anno;
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
}
