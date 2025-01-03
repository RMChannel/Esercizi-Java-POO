public class BadCodeException extends Exception {
    public BadCodeException() {
        super("Un volo con uno stesso codice è già presente");
    }
}
