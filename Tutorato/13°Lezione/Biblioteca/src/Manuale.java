import java.io.Serializable;

public class Manuale extends Libro implements Serializable {
    private String ambito;
    private int difficoltà;
    private String edizione;
    private boolean esercizi;
    public Manuale() {};
    public Manuale(String titolo, String autore, int ISBN, int anno, String ambito, int difficoltà, String edizione, boolean esercizi) {
        super(titolo, autore, ISBN, anno);
        this.ambito = ambito;
        this.difficoltà = difficoltà;
        this.edizione = edizione;
        this.esercizi = esercizi;
    }
    public String getAmbito() {
        return ambito;
    }
    public int getDifficoltà() {
        return difficoltà;
    }
    public String getEdizione() {
        return edizione;
    }
    public boolean isEsercizi() {
        return esercizi;
    }
    @Override
    public String toString() {
        return super.toString()+" Ambito: " + this.ambito + " Difficoltà: " + this.difficoltà + " Edizione: " + this.edizione + " Ci sono esercizi: " + this.esercizi;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass()==Manuale.class) {
            Libro l=(Libro) obj;
            return super.equals(l) && ambito.equals(((Manuale) obj).ambito) && difficoltà==((Manuale) obj).difficoltà && edizione.equals(((Manuale) obj).edizione) && esercizi==((Manuale) obj).esercizi;
        }
        else {
            throw new IllegalArgumentException("L'oggetto dev'essere di tipo manuale");
        }
    }
    @Override
    public Manuale clone() {
        Manuale n = new Manuale();
        Libro l=(Libro) super.clone();
        n.setAnno(l.getAnno());
        n.setAutore(l.getAutore());
        n.setISBN(l.getISBN());
        n.setTitolo(l.getTitolo());
        n.ambito=this.ambito;
        n.edizione=this.edizione;
        n.esercizi=this.esercizi;
        n.difficoltà=this.difficoltà;
        return n;
    }
}
