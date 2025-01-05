package AutoVettura;

public class Ibride extends AutoVettura {
    public Ibride(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public double getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if(!isAccesa()) throw new AutoSpentaException();
        double result = km*((double)(numeroCurve * 20 + numeroRettilinei * 40)/ getNumCavalli());
        super.setTempoImpiegato(result);
        return result;
    }
}
