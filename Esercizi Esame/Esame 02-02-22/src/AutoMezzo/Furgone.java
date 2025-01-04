package AutoMezzo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

public class Furgone extends AutoMezzo {
    public Furgone(String marca, String modello, int cavalliFiscali, String targa) {
        super(marca, modello, cavalliFiscali, targa);
    }

    @Override
    public double reso(GregorianCalendar dataFineNoleggio) {
        LocalDate ld1=getDataInizioNoleggio().toZonedDateTime().toLocalDate();
        LocalDate ld2=dataFineNoleggio.toZonedDateTime().toLocalDate();
        setDisponibile(true);
        return switch (getMarca()) {
            case "Ford" -> ChronoUnit.DAYS.between(ld1, ld2) * 40;
            case "Citroen" -> ChronoUnit.DAYS.between(ld1, ld2) * 35;
            case "Fiat" -> ChronoUnit.DAYS.between(ld1, ld2) * 30;
            default -> throw new AssertionError(getMarca());
        };
    }

    @Override
    public String toString() {
        return "Tipo veicolo: Furgone "+super.toString();
    }
}
