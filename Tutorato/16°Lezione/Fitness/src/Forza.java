import java.io.Serializable;
import java.util.ArrayList;

public class Forza extends Esercizio implements Pianificabile {
    private double peso;
    public Forza(String nome, double durata, int ripetizioni, int difficoltà, String descrizione,double peso) {
        super(nome,durata,ripetizioni,difficoltà,descrizione);
        this.peso = peso;
    }

    public Forza() {
        super("",0,0,1,"");
        peso = 0;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public ArrayList<Esercizio> pianificaAllenamento() {
        ArrayList<Esercizio> esercizi = new ArrayList<>();
        Forza pancaPiana = new Forza("Panca Piana", 40.0, 4, 3, "Esercizio per il petto con bilanciere", 60.0);
        Forza squat = new Forza("Squat", 50.0, 3, 2, "Esercizio per le gambe con bilanciere", 80.0);
        Forza curlBicipiti = new Forza("Curl Bicipiti", 30.0, 5, 1, "Esercizio per i bicipiti con manubri", 15.0);
        esercizi.add(pancaPiana);
        esercizi.add(squat);
        esercizi.add(curlBicipiti);
        return esercizi;
    }

    @Override
    public int compareTo(Esercizio o) {
        return super.compareTo(o);
    }
}
