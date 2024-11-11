import java.util.GregorianCalendar;
import java.util.Objects;

public class RegaloAdulto extends Regalo {
    private String mittente;
    public RegaloAdulto(GregorianCalendar dataDiConsegna, double peso, String regione, String mittente) {
        super(dataDiConsegna, peso, regione);
        this.mittente = mittente;
    }
    public String getMittente() {
        return mittente;
    }
    @Override
    public String toString() {
        return mittente;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())) {
            RegaloAdulto r = (RegaloAdulto)obj;
            return Objects.equals(this.mittente, r.mittente) && super.equals(obj);
        }
        else return false;
    }
    @Override
    public Object clone() {
        return new RegaloAdulto(this.getDataDiConsegna(), this.getPeso(), this.getRegione(), this.mittente);
    }
}
