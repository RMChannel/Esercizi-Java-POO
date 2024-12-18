package it.unisa.compagniaaerea.volo;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class VoloInternazionale extends Volo {
    public VoloInternazionale(String codiceVolo, int ore, GregorianCalendar data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        super(codiceVolo, ore, data, postiDisponibiliEconomy, postiDisponibiliBusiness, miglia);
    }

    @Override
    public double calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException {
        LocalDate month1 = LocalDate.now();
        LocalDate month2 = super.getData().toZonedDateTime().toLocalDate().minusDays(90);
        boolean sconto = false;
        if(month2.isAfter(month1)) {
            sconto = true;
        }
        if(classe.toLowerCase().equals("economy")) {
            super.getPosto(0);
            if(sconto) {
                return 80;
            }
            else return 100;
        }
        else if(classe.toLowerCase().equals("business")) {
            super.getPosto(1);
            if(sconto) {
                return 120;
            }
            else return 150;
        }
        else {
            throw new IllegalArgumentException("Classe non riconosciuta");
        }
    }
}
