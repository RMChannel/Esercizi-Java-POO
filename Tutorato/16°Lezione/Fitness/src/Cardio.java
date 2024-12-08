import javax.smartcardio.Card;
import java.util.ArrayList;

public class Cardio extends Esercizio implements Pianificabile {
    private double velocità;

    public Cardio(String nome, double durata, int ripetizioni, int difficoltà, String descrizione, double velocità) {
        super(nome,durata,ripetizioni,difficoltà,descrizione);
        this.velocità=velocità;
    }

    public Cardio() {
        super("",0,0,1,"");
        velocità=0;
    }

    public double getVelocità() {
        return velocità;
    }

    @Override
    public ArrayList<Esercizio> pianificaAllenamento() {
        ArrayList<Esercizio> esercizi = new ArrayList<>();
        Cardio corsa = new Cardio("Corsa", 30.0, 3, 1, "Allenamento di corsa leggera", 8.5);
        Cardio cyclette = new Cardio("Cyclette", 45.0, 2, 2, "Pedalata a ritmo costante", 6.0);
        Cardio intervalTraining = new Cardio("Interval Training", 20.0, 5, 3, "Alternanza corsa e camminata", 10.0);
        esercizi.add(corsa);
        esercizi.add(cyclette);
        esercizi.add(intervalTraining);
        return esercizi;
    }

    @Override
    public int compareTo(Esercizio e) {
        return super.compareTo(e);
    }
}