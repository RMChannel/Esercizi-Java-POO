public class Prenotazione {
    private String nome;
    private String cognome;
    private int età;
    private String codiceVolo;
    private int tipoBiglietto;
    private Seat posto;
    public Prenotazione(String nome, String cognome, int età, String codiceVolo, int tipoBiglietto, Seat posto) {
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
        this.codiceVolo = codiceVolo;
        this.tipoBiglietto = tipoBiglietto;
        this.posto = posto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", età=" + età +
                ", codiceVolo='" + codiceVolo + '\'' +
                ", tipoBiglietto=" + tipoBiglietto +
                ", posto=" + posto +
                '}';
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public int getTipoBiglietto() {
        return tipoBiglietto;
    }

    public void setTipoBiglietto(int tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public Seat getPosto() {
        return posto;
    }

    public void setPosto(Seat posto) {
        this.posto = posto;
    }
}
