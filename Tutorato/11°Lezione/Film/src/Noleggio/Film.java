package Noleggio;

public class Film {
    private String codice;
    private String titolo;
    public Film(String codice, String titolo) {
        this.codice = codice;
        this.titolo = titolo;
    }
    private Film() {
        codice = "";
        titolo = "";
    }
    public String dammiCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String dammiTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public double calcolaPenaleRitardo(int giorni) {
        return 2*giorni;
    }
    @Override
    public String toString() {
        return "Codice: "+codice+" Titolo: "+titolo;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Film) {
            return codice.equals(((Film) obj).codice) && titolo.equals(((Film) obj).titolo);
        }
        else return false;
    }
    @Override
    public Object clone() {
        Film clone = new Film();
        clone.codice = codice;
        clone.titolo = titolo;
        return clone;
    }
}