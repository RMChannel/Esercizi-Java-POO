public class PrenotazioneNonDisponibileException extends Exception {
    public PrenotazioneNonDisponibileException() {
        super("L'attività è piena");
    }
}
