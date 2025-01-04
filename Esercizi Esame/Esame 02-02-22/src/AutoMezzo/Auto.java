package AutoMezzo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

public class Auto extends AutoMezzo {
    public Auto(String marca, String modello, int cavalliFiscali, String targa) {
        super(marca, modello, cavalliFiscali, targa);
    }

    @Override
    public double reso(GregorianCalendar dataFineNoleggio) {
        LocalDate ld1=getDataInizioNoleggio().toZonedDateTime().toLocalDate();
        LocalDate ld2=dataFineNoleggio.toZonedDateTime().toLocalDate();
        setDisponibile(true);
        return ChronoUnit.DAYS.between(ld1,ld2)*getCavalliFiscali()*3;
    }

    @Override
    public String toString() {
        return "Tipo veicolo: Auto "+super.toString();
    }
}
