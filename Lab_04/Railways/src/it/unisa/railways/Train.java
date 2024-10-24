package it.unisa.railways;
import java.time.LocalTime;
import java.util.List;

public class Train {
    private TrainStop stazioneDiPartenza;
    private TrainStop ultimaStazione;
    private List<TrainStop> fermateIntermedie;
    private int postiOccupati;
    private int kmPercorsi;
    public Train(TrainStop stazioneDiPartenza, TrainStop ultimaStazione, List<TrainStop> fermateIntermedie, int postiOccupati, int kmPercorsi) {
        this.stazioneDiPartenza = stazioneDiPartenza;
        this.ultimaStazione = ultimaStazione;
        this.fermateIntermedie = fermateIntermedie;
        this.postiOccupati = postiOccupati;
        this.kmPercorsi = kmPercorsi;
    }
    public int getTotalNumberOfStops() {
        return 2+fermateIntermedie.size();
    }
    public double computeMaxRevenues(double prezzo) {
        return postiOccupati*prezzo*kmPercorsi;
    }
}