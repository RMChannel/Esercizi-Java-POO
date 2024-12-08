import java.util.ArrayList;

public class PianoAllenamento {
    private int difficoltà;
    private ArrayList<Esercizio> esercizi;

    public PianoAllenamento(int difficoltà) {
        this.difficoltà=difficoltà;
        esercizi=new ArrayList<>();
    }

    public void addEsercizio(Esercizio esercizio) {
        if(esercizio.getDifficoltà()==difficoltà) {
            esercizi.add(esercizio);
        }
        else {
            throw new IllegalArgumentException("L'esercizio non è della stessa difficoltà del piano allenamento");
        }
    }

    public int getDifficultà() {
        return difficoltà;
    }

    public double getDurata() {
        double durata=0;
        for(Esercizio esercizio : esercizi) {
            durata+=esercizio.getDurata();
        }
        return durata;
    }
}
