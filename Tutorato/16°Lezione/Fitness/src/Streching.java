import java.util.ArrayList;

public class Streching extends Esercizio implements Pianificabile {
    private double tempoRecupero;
    public Streching(String nome, double durata, int ripetizioni, int difficoltà, String descrizione, double tempoRecupero) {
        super(nome,durata,ripetizioni,difficoltà,descrizione);
        this.tempoRecupero = tempoRecupero;
    }

    public Streching() {
        super("",0,0,1,"");
        this.tempoRecupero = 0;
    }

    public double getTempoRecupero() {
        return tempoRecupero;
    }

    @Override
    public ArrayList<Esercizio> pianificaAllenamento() {
        ArrayList<Esercizio> esercizi = new ArrayList<>();
        Streching yoga = new Streching("Yoga", 60.0, 1, 3, "Sessione di yoga rilassante", 5.0);
        Streching stretchingDinamico = new Streching("Stretching Dinamico", 20.0, 2, 2, "Allungamenti dinamici prima dell'allenamento", 2.0);
        Streching stretchingStatico = new Streching("Stretching Statico", 15.0, 3, 1, "Allungamenti statici post-allenamento", 3.0);
        esercizi.add(yoga);
        esercizi.add(stretchingDinamico);
        esercizi.add(stretchingStatico);
        return esercizi;
    }

    @Override
    public int compareTo(Esercizio o) {
        return super.compareTo(o);
    }
}
