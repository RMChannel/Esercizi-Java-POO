import java.io.Serializable;

public class Libro implements Serializable, Cloneable {
    private String titolo;
    private String autore;
    private int ISBN;
    private int anno;
    public Libro(String titolo, String autore, int ISBN, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.anno = anno;
    }
    public Libro() {};
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public int getISBN() {
        return ISBN;
    }
    public int getAnno() {
        return anno;
    }
    @Override
    public String toString() {
        return "Titolo: " + this.titolo + ", Autore: " + this.autore + ", ISBN: " + this.ISBN + ", Anno: " + this.anno;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj!=null && obj.getClass() == Libro.class) {
            return this.titolo.equals(((Libro) obj).titolo) && this.anno == ((Libro) obj).anno && this.autore.equals(((Libro) obj).autore) && this.ISBN == ((Libro) obj).ISBN;
        }
        else {
            throw new IllegalArgumentException("L'oggetto passato dev'essere di tipo libro o una sua sottoclasse");
        }
    }
    @Override
    public Object clone() {
        Libro copia = new Libro();
        copia.titolo = this.titolo;
        copia.autore = this.autore;
        copia.ISBN = this.ISBN;
        copia.anno = this.anno;
        return copia;
    }
}
