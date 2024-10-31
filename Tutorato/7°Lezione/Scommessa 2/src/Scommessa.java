public class Scommessa {
    private String CodiceEvento;
    private double SommaPuntata;
    private double QuotazioneScommessa;
    public Scommessa(String CodiceEvento, double SommaPuntata, double QuotazioneScommessa) {
        this.CodiceEvento = CodiceEvento;
        this.SommaPuntata = SommaPuntata;
        this.QuotazioneScommessa = QuotazioneScommessa;
    }
    public double calcolaVincita(boolean Vincita) {return 0.0;}
    public double getQuotazioneScommessa() {
        return QuotazioneScommessa;
    }
    public double getSommaPuntata() {
        return SommaPuntata;
    }
    public String getCodiceEvento() {
        return CodiceEvento;
    }
    public double getQuotazione() {
        return QuotazioneScommessa;
    }
    public String getTipoScommessa() {
        return "";
    }
    public void printScommessa() {
        System.out.println("CodiceEvento: " + CodiceEvento+"\nSomma Puntata: " + SommaPuntata+"\nQuotazione Scommessa: " + QuotazioneScommessa);
    }
}

