public class Pompa {
    private int available;
    private int max;
    public String tipo;
    public Pompa(int available, int max, String tipo) {
        this.available = available;
        this.max = max;
        this.tipo = tipo;
    }
    public int getAvailable() {
        return available;
    }
    public int aggiungi(int n) {
        if (available == max) {
            return 0;
        }
        available += n;
        if(available > max) {
            n=available-max;
            available = max;
        }
        return n;
    }
    public int rifornisci(int n) {
        if(n>available) {
            n=available;
            available=0;
        }
        else available-=n;
        return n;
    }
}
