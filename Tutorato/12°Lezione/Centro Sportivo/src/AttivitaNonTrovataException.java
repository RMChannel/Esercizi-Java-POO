public class AttivitaNonTrovataException extends Exception {
    public AttivitaNonTrovataException() {
        super("L'attività non esiste in questo centro sportivo");
    }
}
