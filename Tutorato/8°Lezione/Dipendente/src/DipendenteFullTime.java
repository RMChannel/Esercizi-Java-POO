public class DipendenteFullTime extends Dipendente {
    private int ferieConcesse;
    private int ferieUtilizzate;
    private int buoniPasto;
    public DipendenteFullTime(String matricola, double stipendio, double straordinario, int buoniPasto) {
        super(matricola,stipendio,straordinario);
        this.ferieConcesse = 0;
        this.ferieUtilizzate = 0;
        this.buoniPasto = buoniPasto;
    }
    public int getBuoniPasto() {
        return buoniPasto;
    }
    public void setBuoniPasto(int buoniPasto) {
        this.buoniPasto = buoniPasto;
    }
    public int getFerieConcesse() {
        return ferieConcesse;
    }
    public void setFerieConcesse(int ferieConcesse) {
        this.ferieConcesse = ferieConcesse;
    }
    public int getFerieUtilizzate() {
        return ferieUtilizzate;
    }
    public void setFerieUtilizzate(int ferieUtilizzate) {
        this.ferieUtilizzate = ferieUtilizzate;
    }
    @Override
    public double paga(int g) {
        double p=super.paga(g);
        if(buoniPasto==0) return p-(ferieUtilizzate*90);
        else return p+(5*buoniPasto)-(ferieConcesse*100);
    }
}
