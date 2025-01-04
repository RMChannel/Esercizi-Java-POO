package ElencoAnimali;

public class BadAnimalException extends RuntimeException {
    public BadAnimalException() {
        super("Il tipo animale specificato non è corretto, riprovare");
    }
}
