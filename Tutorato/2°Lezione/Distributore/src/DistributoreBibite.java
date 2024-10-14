public class DistributoreBibite {
    private int lattine;
    private int gettoni;
    public DistributoreBibite() {
        lattine=0;
        gettoni=0;
    }
    public DistributoreBibite(int lattine, int gettoni) {
        this.lattine=lattine;
        this.gettoni=gettoni;
    }
    public int getLattine() {
        return lattine;
    }
    public int getGettoni() {
        return gettoni;
    }
    public void setLattine(int lattine) {
        this.lattine = lattine;
    }
    public void insertGettone() {
        gettoni++;
    }
    public void insertGettone(int n) {
        gettoni+=n;
    }
    public void getDrink() {
        if(gettoni>0 && lattine>0) {
            gettoni--;
            lattine--;
        }
        else if(gettoni<=0) System.out.println("Non hai abbastanza gettoni");
        else System.out.println("Non sono disponibili lattine");
    }
    public void printDistributore() {
        System.out.println("Lattine: " + getLattine() + " Gettoni: " + getGettoni());
    }
}