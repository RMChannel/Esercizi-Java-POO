package it.unisa.railways;

import java.util.List;

public class ExpressTrain {
    private TrainStop stazioneDiPartenza;
    private TrainStop ultimaStazione;
    private List<TrainStop> fermateIntermedie;
    private int postiOccupati;
    private int postiRistorante;
    private int kmPercorsi;
    public ExpressTrain(TrainStop stazioneDiPartenza, TrainStop ultimaStazione, List<TrainStop> fermateIntermedie, int postiOccupati, int postiRistorante, int kmPercorsi) {
        this.stazioneDiPartenza = stazioneDiPartenza;
        this.ultimaStazione = ultimaStazione;
        this.fermateIntermedie = fermateIntermedie;
        this.postiOccupati = postiOccupati;
        this.postiRistorante = postiRistorante;
        this.kmPercorsi = kmPercorsi;
    }
    public int getTotalNumberOfStops() {
        return 2+fermateIntermedie.size();
    }
    public double computeMaxRevenues(double prezzoPosto, double prezzoRistorante) {
        return (postiOccupati*prezzoPosto*kmPercorsi)+(prezzoRistorante*postiRistorante*kmPercorsi);
    }
}
