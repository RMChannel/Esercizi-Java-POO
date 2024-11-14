package Noleggio;

import java.util.Objects;

public class Azione extends Film {
    public Azione(String codice, String titolo) {
        super(codice, titolo);
    }
    private Azione() {
        super("","");
    }
    @Override
    public double calcolaPenaleRitardo(int giorni) {
        return 3*giorni;
    }
    @Override
    public String toString() {
        return super.toString()+" Tipo: Azione";
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Azione.class)) {
            return super.equals((Film) obj);
        }
        else return false;
    }
    @Override
    public Object clone() {
        Azione temp = new Azione();
        temp.setCodice(dammiCodice());
        temp.setTitolo(dammiTitolo());
        return temp;
    }
}