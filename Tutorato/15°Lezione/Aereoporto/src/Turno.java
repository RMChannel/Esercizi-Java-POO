import java.util.GregorianCalendar;

public class Turno {
    private GregorianCalendar inizio;
    private GregorianCalendar fine;
    public Turno(GregorianCalendar inizio, GregorianCalendar fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public GregorianCalendar getInizio() {
        return inizio;
    }

    public GregorianCalendar getFine() {
        return fine;
    }
}
