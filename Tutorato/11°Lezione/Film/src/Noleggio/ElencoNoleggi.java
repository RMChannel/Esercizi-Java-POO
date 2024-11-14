package Noleggio;

import java.util.ArrayList;
import java.util.Comparator;

public class ElencoNoleggi {
    private ArrayList<Noleggio> noleggi;
    public ElencoNoleggi() {
        noleggi = new ArrayList<Noleggio>();
    }
    public void aggiungiNoleggio(Noleggio noleggio) {
        noleggi.add(noleggio);
        noleggi.sort(new Comparator<Noleggio>() {
            public int compare(Noleggio o1, Noleggio o2) {
                return o1.getFilm().dammiCodice().compareTo(o2.getFilm().dammiCodice());
            }
        });
    }
    public double calcolaPenaliRitardo() {
        double result=0;
        for(Noleggio noleggio : noleggi) {
            result+=noleggio.calcolaPenale();
        }
        return result;
    }
    public ArrayList<Noleggio> cerca(String t) {
        ArrayList<Noleggio> result=new ArrayList<Noleggio>();
        for(Noleggio noleggio : noleggi) {
            if(noleggio.getFilm().dammiTitolo().equalsIgnoreCase(t)) {
                result.add(noleggio);
            }
        }
        return result;
    }
    public ArrayList<Noleggio> getNoleggi() {
        return noleggi;
    }
}
