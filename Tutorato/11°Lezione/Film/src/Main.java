import Noleggio.ElencoNoleggi;
import Noleggio.Film;
import Noleggio.Azione;
import Noleggio.Commedia;
import Noleggio.Noleggio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ElencoNoleggi elenco = new ElencoNoleggi();
        Film f1=new Azione("AC1ADW","Mission Impossibile");
        Film f2=new Commedia("CMV21D","Tre uomini e una gamba");
        Azione f3 =(Azione) f1.clone();
        Commedia f4 =(Commedia) f2.clone();
        f3.setCodice("ACCF1E2DC");
        f4.setCodice("AJVMGN");
        Noleggio n1=new Noleggio(f1,3);
        Noleggio n2=new Noleggio(f2,5);
        Noleggio n3=new Noleggio(f3,4);
        Noleggio n4=new Noleggio(f4,6);
        elenco.aggiungiNoleggio(n1);
        elenco.aggiungiNoleggio(n2);
        elenco.aggiungiNoleggio(n3);
        elenco.aggiungiNoleggio(n4);
        for(Noleggio noleggio:elenco.getNoleggi()) System.out.println(noleggio.getFilm().toString()+" Penale film: "+noleggio.calcolaPenale());
        System.out.println("\nCosto finale penali: "+elenco.calcolaPenaliRitardo()+"\n");
        ArrayList<Noleggio> result=elenco.cerca("Tre uomini e una gamba");
        for(Noleggio noleggio:result){
            System.out.println(noleggio.getFilm().toString());
        }
    }
}