package TesseraSportiva;

public class AttivitaException extends RuntimeException {
    public AttivitaException() {
        super("L'attività è già presente nella tessera");
    }
}
