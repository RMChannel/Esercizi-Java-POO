package Hotel;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Prenotazione implements Serializable {
    private GregorianCalendar checkin;
    private GregorianCalendar checkout;
    private Cliente cliente;
    private Stanza stanza;

    public Prenotazione(GregorianCalendar checkin, GregorianCalendar checkout, Cliente cliente, Stanza stanza) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.cliente = cliente;
        this.stanza = stanza;
    }

    public GregorianCalendar getCheckin() {
        return checkin;
    }

    public GregorianCalendar getCheckout() {
        return checkout;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setCheckout(GregorianCalendar checkout) {
        this.checkout = checkout;
    }
}
