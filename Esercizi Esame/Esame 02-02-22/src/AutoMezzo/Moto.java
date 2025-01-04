package AutoMezzo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Moto extends AutoMezzo {
    public Moto(String marca, String modello, int cavalliFiscali, String targa) {
        super(marca, modello, cavalliFiscali, targa);
    }

    @Override
    public double reso(GregorianCalendar dataFineNoleggio) {
        GregorianCalendar dataInizio = getDataInizioNoleggio();
        double result=0;
        while (dataInizio.before(dataFineNoleggio)) {
            if(dataInizio.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || dataInizio.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                result+=30;
            }
            else {
                result+=20;
            }
            dataInizio.add(Calendar.DATE, 1);
        }
        setDisponibile(true);
        return result;
    }

    @Override
    public String toString() {
        return "Tipo veicolo: Moto "+super.toString();
    }
}
