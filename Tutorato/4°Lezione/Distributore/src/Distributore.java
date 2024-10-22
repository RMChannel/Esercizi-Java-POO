public class Distributore {
    public String città;
    public String proprietario;
    public Pompa pompa;
    private double costoAcquisto=1.2;
    private double costoVendita=1.8;
    private double spese=0;
    private double guadagno=0;
    public Distributore(String città, String proprietario, int litri,String tipo) {
        this.città = città;
        this.proprietario = proprietario;
        this.pompa = new Pompa(litri,500,tipo);
    }
    public void rifornisci(int n) {
        int temp=pompa.rifornisci(n);
        if(temp==0) System.out.println("Pompa senza carburante");
        else guadagno+=temp*costoVendita;
    }
    public void aggiungi(int n) {
        int temp=pompa.aggiungi(n);
        if(temp==0) System.out.println("Pompa al massimo");
        else spese+=costoAcquisto*temp;
    }
    public int litri() {
        return pompa.getAvailable();
    }
    public double ricavo() {
        return guadagno-spese;
    }
}
