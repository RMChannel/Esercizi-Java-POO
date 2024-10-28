public class ContoCorrente {
    private String nomeTitolare;
    private String cognomeTitolare;
    private int nMovimenti = 0;
    private static final int maxMovimenti = 50;
    private double saldo = 0;

    public ContoCorrente(String nomeTitolare, String cognomeTitolare) {
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
    }

    public ContoCorrente(String nomeTitolare, String cognomeTitolare, double saldo) {
        this.nomeTitolare = nomeTitolare;
        this.cognomeTitolare = cognomeTitolare;
        this.saldo = saldo;
    }

    public void preleva(double x) throws Exception {
        if (nMovimenti >= maxMovimenti) x += 0.5;
        nMovimenti++;
        saldo -= x;
        if (saldo < 0) {
            saldo+=x;
            throw new Exception("Il conto è in rosso");
        }
    }
    public String restituisciSaldo() {
        return "Saldo: " + saldo+"€ Titolare: "+nomeTitolare+" "+cognomeTitolare;
    }
}