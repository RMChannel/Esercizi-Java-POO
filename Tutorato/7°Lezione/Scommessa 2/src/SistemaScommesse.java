import java.util.ArrayList;

public class SistemaScommesse {
    ArrayList<Scommessa> scommesse;
    public SistemaScommesse() {
        scommesse = new ArrayList<>();
    }
    public void aggiungiScommessa(Scommessa s) {
        scommesse.add(s);
    }
    String daiTipoScommessa(int i) {
        return scommesse.get(i).getClass().getSimpleName();
    }
    public Scommessa getMinimo() {
        Scommessa minimo = scommesse.getFirst();
        for(Scommessa s: scommesse) {
            if(s.calcolaVincita(true)<minimo.calcolaVincita(true)) {
                minimo = s;
            }
        }
        return minimo;
    }
    public Scommessa getMassimo() {
        Scommessa massimo = scommesse.getFirst();
        for(Scommessa s: scommesse) {
            if(s.calcolaVincita(true)>massimo.calcolaVincita(true)) {
                massimo = s;
            }
        }
        return massimo;
    }
    public double calcolaVincita() {
        double result=0;
        for(Scommessa s: scommesse) {
            result+=s.calcolaVincita(true);
        }
        return result;
    }
    public ArrayList<Scommessa> cerca(String tipo) {
        ArrayList<Scommessa> found = new ArrayList<>();
        for(Scommessa s: scommesse) {
            if(s.getClass().getSimpleName().equals(tipo)) {
                found.add(s);
            }
        }
        return found;
    }
}
