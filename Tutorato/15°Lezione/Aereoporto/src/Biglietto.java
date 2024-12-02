public class Biglietto {
    private int id;
    private Passeggero passeggero;
    private double prezzo;
    private Volo volo;

    public int getId() {
        return id;
    }

    public Passeggero getPasseggero() {
        return passeggero;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Volo getVolo() {
        return volo;
    }

    public Biglietto(int id, Passeggero passeggero, double prezzo, Volo volo) {
        this.id = id;
        this.passeggero = passeggero;
        this.prezzo = prezzo;
        this.volo = volo;
    }
}
