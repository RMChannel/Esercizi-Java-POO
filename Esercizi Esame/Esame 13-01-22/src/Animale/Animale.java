package Animale;

public abstract class Animale {
    private final String nome;
    private final double peso;
    private final int zampe;
    private final int maxContatore;
    private int contatore;

    public Animale(String nome, double peso, int zampe, int maxContatore) {
        this.nome = nome;
        this.peso = peso;
        this.zampe = zampe;
        this.maxContatore = maxContatore;
        contatore = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public int getZampe() {
        return zampe;
    }

    public int getMaxContatore() {
        return maxContatore;
    }

    public boolean vuoiMangiare() {
        if(contatore<getMaxContatore()) {
            contatore++;
            return false;
        }
        else return true;
    }

    public void mangia() {
        if(contatore==getMaxContatore()) {
            contatore=0;
        }
    }

    @Override
    public String toString() {
        return "Animale.Animale{" +
                "nome='" + nome + '\'' +
                ", peso=" + peso +
                ", zampe=" + zampe +
                ", maxContatore=" + maxContatore +
                ", contatore=" + contatore +
                '}';
    }
}
