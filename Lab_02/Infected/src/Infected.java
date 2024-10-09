public class Infected {

    private final String disease;
    private int numberOfInfected;

    public Infected(String disease2) {
        numberOfInfected = 0;
        disease=disease2;
    }

    public Infected(String disease2, int numberOfInfected2) {
        numberOfInfected = numberOfInfected2;
        disease=disease2;
    }

    public int getNumberOfInfected() {
        return numberOfInfected;
    }

    public String getDisease() {
        return disease;
    }

    public void addInfected(int newNumberOfInfected) {
        numberOfInfected+=newNumberOfInfected;
    }

    public void updateInfectedByRt(double Rt) {
        numberOfInfected= (int) (numberOfInfected*Rt);
    }
}