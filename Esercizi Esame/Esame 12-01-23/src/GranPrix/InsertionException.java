package GranPrix;

public class InsertionException extends RuntimeException {
    public InsertionException() {
        super("L'autovettura è già presente nel GranPrix");
    }
}
