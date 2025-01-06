package Ticket;

import TesseraSportiva.TicketNonUsabileException;

public interface Usabile {
    void usaTicket() throws TicketNonUsabileException;
}
