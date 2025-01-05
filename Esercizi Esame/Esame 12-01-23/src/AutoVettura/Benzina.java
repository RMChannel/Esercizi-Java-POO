package AutoVettura;

public class Benzina extends AutoVettura{
    public Benzina(String nome, int numCavalli) {
        super(nome, numCavalli);
    }

    @Override
    public double getTempoGiro(int km, int numeroCurve, int numeroRettilinei) throws AutoSpentaException {
        if(!isAccesa()) throw new AutoSpentaException();
        double result = km*((double)(numeroCurve * 30 + numeroRettilinei * 30)/ getNumCavalli());
        super.setTempoImpiegato(result);
        return result;
    }
}
