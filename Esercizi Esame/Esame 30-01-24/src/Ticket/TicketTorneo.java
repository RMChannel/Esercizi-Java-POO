package Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TicketTorneo extends TicketSportivo implements Usabile, Serializable {
    private ArrayList<GregorianCalendar> utilizzi;

    public TicketTorneo(String attività, String località, double prezzo) {
        super(attività,località,prezzo);
        utilizzi = new ArrayList<>();
    }

    @Override
    public void usaTicket() {
        utilizzi.add(new GregorianCalendar());
    }

    @Override
    public boolean isUsable() {
        return utilizzi.size() != 7;
    }

    @Override
    public String toString() {
        return "Tipo Biglietto: Torneo, "+super.toString();
    }
}
