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
        return scommesse.get(i).getTipoScommessa();
    }
    Scommessa getMinimo() {
        Scommessa minimo = scommesse.get(0);
        for(Scommessa s: scommesse) {
            if(s.calcolaVincita(true)<minimo.calcolaVincita(true)) {
                minimo = s;
            }
        }
        return minimo;
    }
    Scommessa getMassimo() {
        Scommessa massimo = scommesse.get(0);
        for(Scommessa s: scommesse) {
            if(s.calcolaVincita(true)>massimo.calcolaVincita(true)) {
                massimo = s;
            }
        }
        return massimo;
    }
    double calcolaVincita() {
        double result=0;
        for(Scommessa s: scommesse) {
            result+=s.calcolaVincita(true);
        }
        return result;
    }
    ArrayList<Scommessa> cerca(String tipo) {
        ArrayList<Scommessa> found = new ArrayList<>();
        for(Scommessa s: scommesse) {
            if(s.getTipoScommessa().equals(tipo)) {
                found.add(s);
            }
        }
        return found;
    }
}
