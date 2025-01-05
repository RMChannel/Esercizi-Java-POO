package GranPrix;

import AutoVettura.AutoVettura;
import AutoVettura.AutoSpentaException;

import java.util.ArrayList;

public class GranPrix {
    private ArrayList<AutoVettura> vetture;
    private final int numeroGiri;
    private final int km;
    private final int numeroCurve;
    private final int numeroRettilinei;

    public GranPrix(int km, int numeroGiri, int numeroCurve, int numeroRettilinei) {
        vetture = new ArrayList<AutoVettura>();
        this.numeroGiri = numeroGiri;
        this.km = km;
        this.numeroCurve = numeroCurve;
        this.numeroRettilinei = numeroRettilinei;
    }

    public ArrayList<AutoVettura> getVetture() {
        return vetture;
    }

    public int getNumeroGiri() {
        return numeroGiri;
    }

    public int getKm() {
        return km;
    }

    public int getNumeroCurve() {
        return numeroCurve;
    }

    public int getNumeroRettilinei() {
        return numeroRettilinei;
    }

    public void AddVetture(AutoVettura vet) {
        for(AutoVettura v : vetture) {
            if(v.getNome().equals(vet.getNome())) {
                throw new InsertionException();
            }
        }
        vetture.add(vet);
        vetture.sort(AutoVettura::compareTo);
    }

    public void avviaMotori() {
        for (AutoVettura vet : vetture) {
            vet.start();
        }
    }

    public void pitStop(int i) {
        vetture.get(i).setTempoImpiegato(2);
    }

    public void effettuaGiro() {
        for(AutoVettura vet : vetture) {
            try {
                vet.getTempoGiro(km,numeroCurve,numeroRettilinei);
            } catch (AutoSpentaException e) {
                System.err.println("L'auto "+vet.getNome()+" è spenta");
            }
        }
    }
}
