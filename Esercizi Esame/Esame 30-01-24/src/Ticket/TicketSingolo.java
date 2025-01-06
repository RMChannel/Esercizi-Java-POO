package Ticket;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class TicketSingolo extends TicketSportivo implements Usabile, Serializable {
    private GregorianCalendar dataUtilizzo;

    public TicketSingolo(String attività, String località, double prezzo) {
        super(attività,località,prezzo);
        dataUtilizzo = null;
    }

    @Override
    public void usaTicket() {
        dataUtilizzo = new GregorianCalendar();
    }

    @Override
    public boolean isUsable() {
        return dataUtilizzo == null;
    }

    @Override
    public String toString() {
        return "Tipo Biglietto: Singolo, "+super.toString();
    }
}
