public class main {
    public static void main(String[] args) {
        DistributoreBibite d = new DistributoreBibite(5,0);
        d.insertGettone();
        d.getDrink();
        d.printDistributore();
        d.getDrink();
        d.insertGettone(4);
        for(int i=0;i<4;i++) {
            d.getDrink();
            d.printDistributore();
        }
        d.insertGettone();
        d.printDistributore();
        d.getDrink();
    }
}