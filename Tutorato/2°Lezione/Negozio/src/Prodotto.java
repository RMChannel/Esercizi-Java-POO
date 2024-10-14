public class Prodotto {
    private int codice;
    private double prezzo;
    private String nome;
    public Prodotto(int codice, double prezzo, String nome) {
        this.codice = codice;
        this.prezzo = prezzo;
        this.nome = nome;
    }
    public void printProdotto() {
        System.out.println("Codice: " + codice+ " Prezzo: " + prezzo+ " Nome: " + nome);
    }
    public int getCodice() {
        return codice;
    }
    public double getPrezzo() {
        return prezzo;
    }
}
