import java.util.GregorianCalendar;

public class Regalo implements Cloneable {
    private GregorianCalendar dataDiConsegna;
    private double peso;
    private String regione;
    public Regalo(GregorianCalendar dataDiConsegna, double peso, String regione) {
        this.dataDiConsegna = dataDiConsegna;
        this.peso = peso;
        this.regione = regione;
    }
    @Override
    public String toString() {
        return dataDiConsegna.toString() + " " + peso + " " + regione;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false; {
            Regalo regalo = (Regalo) obj;
            return regalo.dataDiConsegna.equals(this.dataDiConsegna) && regalo.peso == this.peso && regalo.regione.equals(this.regione);
        }
    }
    @Override
    public Object clone() {
        Regalo r2=new Regalo(dataDiConsegna, peso, regione);
        return r2;
    }
    public int calcolaCosto() {
        switch (regione) {
            case("Nord"):
                return 10;
            case("Centro"):
                return 15;
            case("Sud"):
                return 20;
            default:
                return 0;
        }
    }
    public GregorianCalendar getDataDiConsegna() {
        return dataDiConsegna;
    }

    public double getPeso() {
        return peso;
    }

    public String getRegione() {
        return regione;
    }
}
