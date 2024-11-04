public class ScommessaCalcistica extends Scommessa {
    private String Competizione;
    private String SquadraA;
    private String SquadraB;
    private char scommessa;
    public ScommessaCalcistica(String CodiceEvento, double SommaPuntata, double QuotazioneScommessa, String Competizione, String SquadraA, String SquadraB, char scommessa) {
        super(CodiceEvento,SommaPuntata,QuotazioneScommessa);
        this.Competizione = Competizione;
        this.SquadraA = SquadraA;
        this.SquadraB = SquadraB;
        this.scommessa = scommessa;
    }

    @Override
    public double calcolaVincita(boolean Vincita) {
        if(Vincita) return super.getQuotazioneScommessa()*super.getSommaPuntata();
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
    public char getScommessa() {
        return scommessa;
    }
    @Override
    public void printScommessa() {
        super.printScommessa();
        System.out.println("Competizione: " + getCompetizione()+"\nSquadra A: "+getSquadraA()+"\nSquadra B: "+getSquadraB());
    }
}
