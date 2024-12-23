import java.io.NotActiveException;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class StudentCard extends Card implements Serializable {
    private String matricola;
    private GregorianCalendar scadenza;
    private double saldo;
    private char fascia;
    private boolean bonus;

    public StudentCard(int codice, String nome, String cognome, boolean active, String matricola, GregorianCalendar scadenza, double saldo, char fascia, boolean bonus) {
        super(codice, nome, cognome, active);
        this.matricola = matricola;
        this.scadenza = scadenza;
        this.saldo = saldo;
        this.fascia = fascia;
        this.bonus = bonus;
    }

    public String getMatricola() {
        return matricola;
    }

    public GregorianCalendar getScadenza() {
        return scadenza;
    }

    public double getSaldo() {
        return saldo;
    }

    public char getFascia() {
        return fascia;
    }

    public boolean isBonus() {
        return bonus;
    }

    public double calcolaPrezzo() {
        double prezzo = 0;
        if(fascia == 'A') prezzo = 2.5;
        else if(fascia == 'B') prezzo = 1.5;
        if(bonus) prezzo-=1;
        if(prezzo<=0) throw new RuntimeException("Prezzo non valido");
        return prezzo;
    }

    public double simulatePayment() throws ExpiredCardException, InsufficientBalanceException, NotActiveException {
        if(!isActive()) throw new NotActiveException();
        GregorianCalendar now = new GregorianCalendar();
        double prezzo = calcolaPrezzo();
        if(now.compareTo(scadenza) > 0) throw new ExpiredCardException("Scadenza non valida");
        else if(saldo<prezzo) throw new InsufficientBalanceException("Saldo insufficiente");
        return prezzo;
    }

    public void pay(double x) {
        if(x<0) throw new RuntimeException("Importo non valido");
        saldo -= x;
    }
}