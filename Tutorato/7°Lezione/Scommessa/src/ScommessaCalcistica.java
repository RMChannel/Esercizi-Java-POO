public class ScommessaCalcistica extends Scommessa {
    private String Competizione;
    private String SquadraA;
    private String SquadraB;
    public ScommessaCalcistica(String CodiceEvento, double SommaPuntata, double QuotazioneScommessa, String Competizione, String SquadraA, String SquadraB) {
        super(CodiceEvento,SommaPuntata,QuotazioneScommessa);
        this.Competizione = Competizione;
        this.SquadraA = SquadraA;
        this.SquadraB = SquadraB;
    }

    @Override
    public double calcolaVincita(boolean Vincita) {
        if(Vincita) return super.getQuotazioneScommessa()*getSommaPuntata();
        else return 0.0;
    }

    public String getCompetizione() {
        return Competizione;
    }
    public String getSquadraA() {
        return SquadraA;
    }
    public String getSquadraB() {
        return SquadraB;
    }
    @Override
    public void printScommessa() {
        super.printScommessa();
        System.out.println("Competizione: " + getCompetizione()+"\nSquadra A: "+getSquadraA()+"\nSquadra B: "+getSquadraB());
    }
}
