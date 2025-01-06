package TesseraSportiva;

import Ticket.TicketSportivo;

import java.io.Serializable;
import java.util.ArrayList;

public class TesseraSportiva implements Serializable {
    private final String nome;
    private final String cognome;
    private ArrayList<TicketSportivo> tickets;
    private double costo;

    public TesseraSportiva(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.tickets = new ArrayList<>();
        this.costo = 0;
    }

    public void addTicket(TicketSportivo t) throws ListaPienaException {
        if(tickets.size() == 5) {
            throw new ListaPienaException();
        }
        for(TicketSportivo ticket : tickets) {
            if(ticket.getAttività().equals(t.getAttività())) {
                throw new AttivitaException();
            }
        }
        tickets.add(t);
        costo+=t.getCosto();
    }

    public void utilizza(int i) throws TicketNonUsabileException {
        if(i>=tickets.size()) {
            return;
        }
        else {
            if(tickets.get(i).isUsable()) {
                tickets.get(i).usaTicket();
            }
            else {
                throw new TicketNonUsabileException();
            }
        }
    }

    public boolean isUsabile() {
        for(TicketSportivo ticket : tickets) {
            if(ticket.isUsable()) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public ArrayList<TicketSportivo> getTickets() {
        return tickets;
    }

    public double getCosto() {
        return costo-((costo*20)/100);
    }
}
