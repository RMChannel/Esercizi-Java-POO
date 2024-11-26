import java.io.Serializable;

public class LibroNarrativa extends Libro implements Serializable {
    private String genere;
    private String lingua;
    private boolean premiato;
    private int numeroCapitoli;
    public LibroNarrativa() {
        super();
    };
    public LibroNarrativa(String titolo, String autore, int ISBN, int anno, String genere, String lingua, boolean premiato, int numeroCapitoli) {
        super(titolo, autore, ISBN, anno);
        this.genere = genere;
        this.lingua = lingua;
        this.premiato = premiato;
        this.numeroCapitoli = numeroCapitoli;
    }
    public String getGenere() {
        return genere;
    }
    public String getLingua() {
        return lingua;
    }
    public boolean isPremiato() {
        return premiato;
    }
    public int getNumeroCapitoli() {
        return numeroCapitoli;
    }
    @Override
    public String toString() {
        return super.toString()+" Genere: " + this.genere + "Lingua originale: " + this.lingua + "è premiato: "+ this.premiato + "numero di capitoli: " + this.numeroCapitoli;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass()==LibroNarrativa.class) {
            Libro libro=(Libro)obj;
            return super.equals(libro) && this.genere.equals(((LibroNarrativa) obj).genere) && this.lingua.equals(((LibroNarrativa) obj).lingua) && premiato==((LibroNarrativa) obj).premiato && numeroCapitoli==((LibroNarrativa) obj).numeroCapitoli;
        }
        else {
            return false;
        }
    }
    @Override
    public Object clone() {
        LibroNarrativa n = new LibroNarrativa();
        Libro l=(Libro) super.clone();
        n.setAnno(l.getAnno());
        n.setAutore(l.getAutore());
        n.setISBN(l.getISBN());
        n.setTitolo(l.getTitolo());
        n.genere = genere;
        n.lingua = lingua;
        n.premiato = premiato;
        n.numeroCapitoli = numeroCapitoli;
        return n;
    }
}
