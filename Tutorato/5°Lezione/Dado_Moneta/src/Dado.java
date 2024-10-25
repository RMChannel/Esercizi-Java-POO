import java.util.Random;

public class Dado implements Lancio {
    private static int lanci = 0;
    private static final Random r = new Random();
    public int lancio() {
        lanci++;
        return r.nextInt(6)+1;
    }
    public static int getLanci() {
        return lanci;
    }
}