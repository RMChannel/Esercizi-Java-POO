package Noleggio;

public class Commedia extends Film {
    public Commedia(String codice, String titolo) {
        super(codice, titolo);
    }
    private Commedia() {
        super("","");
    }
    @Override
    public double calcolaPenaleRitardo(int giorni) {
        return 2.50 * giorni;
    }
    @Override
    public String toString() {
        return super.toString()+" Tipo Film: Commedia";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Commedia.class)) {
            return super.equals((Film) obj);
        }
        else return false;
    }
    @Override
    public Object clone() {
        Commedia temp = new Commedia();
        temp.setCodice(dammiCodice());
        temp.setTitolo(dammiTitolo());
        return temp;
    }
}
