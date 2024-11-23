public class PrenotazioneDuplicataException extends Exception {
    public PrenotazioneDuplicataException() {
        super("La prenotazione è già stata effettuata da quest'utente");
    }
}
