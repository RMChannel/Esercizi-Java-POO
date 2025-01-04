package Hertz;

import AutoMezzo.AutoMezzo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Hertz {
    private ArrayList<AutoMezzo> autoMezzi;
    public Hertz() {
        autoMezzi = new ArrayList<AutoMezzo>();
    }

    public void addAutoMezzo(AutoMezzo autoMezzo) {
        autoMezzi.add(autoMezzo);
    }

    public AutoMezzo dammiAutomezzoPerTarga(String targa) {
        for (AutoMezzo autoMezzo : autoMezzi) {
            if (autoMezzo.getTarga().equals(targa)) {
                return autoMezzo;
            }
        }
        return null;
    }

    public AutoMezzo dammiAutomezziPerModello(String modello) {
        for (AutoMezzo autoMezzo : autoMezzi) {
            if (autoMezzo.getModello().equals(modello)) {
                return autoMezzo;
            }
        }
        return null;
    }

    public ArrayList<AutoMezzo> dammiAutomezziInPrestito() {
        ArrayList<AutoMezzo> result = new ArrayList<AutoMezzo>();
        for (AutoMezzo autoMezzo : autoMezzi) {
            if(!autoMezzo.isDisponibile()) {
                result.add(autoMezzo);
            }
        }
        return result;
    }

    public ArrayList<AutoMezzo> dammiAutomezziNonInPrestito() {
        ArrayList<AutoMezzo> result = new ArrayList<AutoMezzo>();
        for (AutoMezzo autoMezzo : autoMezzi) {
            if(autoMezzo.isDisponibile()) {
                result.add(autoMezzo);
            }
        }
        return result;
    }

    public void effettuaPrestito(String targa) {
        for (AutoMezzo autoMezzo : autoMezzi) {
            if (autoMezzo.getTarga().equals(targa)) {
                autoMezzo.prestito();
                return;
            }
        }
        throw new TargaException();
    }

    public double effettuaReso(String targa, GregorianCalendar dataFineNoleggio) throws PrestitoException {
        for (AutoMezzo autoMezzo : autoMezzi) {
            if (autoMezzo.getTarga().equals(targa)) {
                if(autoMezzo.isDisponibile()) {
                    throw new PrestitoException();
                }
                return autoMezzo.reso(dataFineNoleggio);
            }
        }
        throw new TargaException();
    }
}
