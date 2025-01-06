package Ticket;

import java.io.Serializable;

public abstract class TicketSportivo implements Usabile, Serializable {
    private String attività;
    private String località;
    private double costo;

    public TicketSportivo(String attività, String località, double costo) {
        this.attività=attività;
        this.località=località;
        this.costo=costo;
    }

    public String getAttività() {
        return attività;
    }

    public String getLocalità() {
        return località;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public abstract void usaTicket();

    public abstract boolean isUsable();

    @Override
    public String toString() {
        return "Attività: "+attività+", Località: "+località+", Costo: "+costo+"€";
    }
}
