public class DipendentePartTime extends Dipendente {
    private int malattia;
    public DipendentePartTime(String matricola, double stipendio, double straordinario) {
        super(matricola, stipendio, straordinario);
        malattia=0;
    }
    public void prendiMalattia(int g) {
        malattia+=g;
    }
    public int getMalattia() {
        return malattia;
    }
    @Override
    public double paga(int g) {
        double p=super.paga(g);
        if(malattia==0) return p;
        else return (p-(malattia*15));
    }
}
