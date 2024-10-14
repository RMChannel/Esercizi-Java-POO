import java.util.ArrayList;

public class RegistratoreCassa {
    private ArrayList<Prodotto> listaProdotti;
    private double fondo;
    public RegistratoreCassa(double fondo){
        this.fondo=fondo;
        listaProdotti=new ArrayList<>();
    }
    public void aggiungiProdotto(Prodotto p) {
        listaProdotti.add(p);
    }
    public void printProdotti() {
        for(Prodotto p:listaProdotti){
            p.printProdotto();
        }
    }
    public double acquista(double denaro, int codice) {
        for(Prodotto p:listaProdotti){
            if(codice==p.getCodice()) {
                if(denaro>=p.getPrezzo()) {
                    denaro-=p.getPrezzo();
                    denaro=Math.round(denaro*100.0)/100.0;
                    if(denaro>0) {
                        fondo-=denaro;
                    }
                    System.out.println("Fondo rimanente: "+fondo);
                }
                else System.out.println("I soldi non sono sufficienti");
                return denaro;
            }
        }
        System.out.println("Prodotto non trovato");
        return denaro;
    }
}
