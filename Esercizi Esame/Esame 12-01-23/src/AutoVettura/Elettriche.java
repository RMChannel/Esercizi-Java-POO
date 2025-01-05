package AutoVettura;

public class Elettriche extends AutoVettura {
    public Elettriche(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public double getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if(!isAccesa()) throw new AutoSpentaException();
        double result = km*((double)(numeroCurve * 15 + numeroRettilinei * 45)/ getNumCavalli());
        super.setTempoImpiegato(result);
        return result;
    }
}
