public class Seat {
    private int numero;
    private char posizione;
    private boolean occupato;

    public Seat(int numero, char posizione, boolean occupato) {
        this.numero = numero;
        this.posizione = posizione;
        this.occupato = occupato;
    }

    public Seat(int numero, char posizione) {
        this.numero = numero;
        this.posizione = posizione;
        this.occupato = false;
    }

    public int getNumero() {
        return numero;
    }

    public char getPosizione() {
        return posizione;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
