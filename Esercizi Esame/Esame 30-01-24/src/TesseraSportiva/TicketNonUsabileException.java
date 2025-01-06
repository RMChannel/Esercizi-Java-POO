package TesseraSportiva;

public class TicketNonUsabileException extends Exception {
    public TicketNonUsabileException() {
        super("Ticket non utilizzabile");
    }
}
