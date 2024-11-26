import java.io.Serializable;

public class Fumetto extends Libro implements Serializable {
    private String disegnatore;
    private String casaEditrice;
    private int numeroDiPagine;
    private boolean serie;
    private String target;
    public Fumetto() {};
    public Fumetto(String titolo, String autore, int ISBN, int anno, String disegnatore, String casaEditrice, int numeroDiPagine, boolean serie, String target) {
        super(titolo, autore, ISBN, anno);
        this.disegnatore = disegnatore;
        this.casaEditrice = casaEditrice;
        this.numeroDiPagine = numeroDiPagine;
        this.serie = serie;
        this.target = target;
    }

    public String getDisegnatore() {
        return disegnatore;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public int getNumeroDiPagine() {
        return numeroDiPagine;
    }

    public boolean isSerie() {
        return serie;
    }

    public String getTarget() {
        return target;
    }
    @Override
    public String toString() {
        return super.toString() + ", Disegnatore: " + this.disegnatore + ", Casa editrice: " + this.casaEditrice + ", Numero di pagine illustrate: " + this.numeroDiPagine + ", Target: " + this.target + ", Fa parte di una serie: " + this.serie;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass()==Fumetto.class) {
            Libro lib = (Libro) obj;
            return super.equals(lib) && this.disegnatore.equals(((Fumetto)obj).disegnatore) && this.casaEditrice.equals(((Fumetto)obj).casaEditrice) && this.numeroDiPagine==((Fumetto)obj).numeroDiPagine && this.serie==((Fumetto)obj).serie && this.target.equals(((Fumetto)obj).target);
        }
        else return false;
    }
    @Override
    public Object clone() {
        Fumetto fumetto = new Fumetto();
        Libro l=(Libro) super.clone();
        fumetto.setAnno(l.getAnno());
        fumetto.setAutore(l.getAutore());
        fumetto.setISBN(l.getISBN());
        fumetto.setTitolo(l.getTitolo());
        fumetto.disegnatore = this.disegnatore;
        fumetto.casaEditrice = this.casaEditrice;
        fumetto.numeroDiPagine = this.numeroDiPagine;
        fumetto.serie = this.serie;
        fumetto.target = this.target;
        return fumetto;
    }
}
