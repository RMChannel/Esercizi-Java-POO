public class ScommessaIppica extends Scommessa {
    private String TipologiaGara;
    private int TipoScommessa;
    Cavalli cavalli;
    public ScommessaIppica(String CodiceEvento, double SommaPuntata, double QuotazioneScommessa, String TipologiaGara, int TipoScommessa, Cavalli cavalli) {
        super(CodiceEvento, SommaPuntata, QuotazioneScommessa);
        this.TipologiaGara = TipologiaGara;
        this.TipoScommessa = TipoScommessa;
        this.cavalli = cavalli;
    }
    public double calcolaVincita(boolean Vincita) {
        if(Vincita) {
            if(TipoScommessa==1) return super.getQuotazioneScommessa()*getSommaPuntata();
            else if(TipoScommessa==2) return super.getQuotazioneScommessa()*getSommaPuntata()*cavalli.GetN();
            else return -1.0;
        }
        else return 0.0;
    }
    public String getTipologiaGara() {
        return TipologiaGara;
    }
    public int getTipoScommessa() {
        return TipoScommessa;
    }
    public Cavalli getCavalli() {
        return cavalli;
    }

    @Override
    public void printScommessa() {
        super.printScommessa();
        System.out.println("TipologiaGara: " + TipologiaGara+"\nTipoScommessa: " + TipoScommessa+"\nNumero di cavalli: " + cavalli.GetN());
        cavalli.printCavalli();
    }
}
