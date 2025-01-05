package AutoVettura;

public abstract class AutoVettura implements Comparable<AutoVettura> {
    private String nome;
    private int numCavalli;
    private double tempoImpiegato;
    private boolean accesa;

    public AutoVettura(String nome, int numCavalli) {
        this.nome = nome;
        this.numCavalli = numCavalli;
        tempoImpiegato = 0;
        accesa = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCavalli() {
        return numCavalli;
    }

    public void setNumCavalli(int numCavalli) {
        this.numCavalli = numCavalli;
    }

    public double getTempoImpiegato() {
        return tempoImpiegato;
    }

    public void setTempoImpiegato(double tempoImpiegato) {
        this.tempoImpiegato += tempoImpiegato;
    }

    public boolean isAccesa() {
        return accesa;
    }

    public void start() {
        accesa = true;
    }

    public void stop() {
        accesa = false;
        tempoImpiegato = 0;
    }

    public abstract double getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException;

    @Override
    public int compareTo(AutoVettura o) {
        return numCavalli - o.numCavalli;
    }
}
