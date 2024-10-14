public class Main {
    public static void main(String[] args) {
        Prodotto p1=new Prodotto(2345,799.99,"PS5 PRO");
        Prodotto p2=new Prodotto(6722,499.99,"Xbox Series X");
        Prodotto p3=new Prodotto(8217,349.99,"Nintendo Switch OLED");
        RegistratoreCassa cassa=new RegistratoreCassa(500);
        cassa.aggiungiProdotto(p1);
        cassa.aggiungiProdotto(p2);
        cassa.aggiungiProdotto(p3);
        cassa.printProdotti();
        double denaro=400;
        denaro=cassa.acquista(denaro,8217);
        System.out.println("Denaro rimanente: "+denaro);
        denaro=cassa.acquista(denaro,1333);
        System.out.println("Denaro rimanente: "+denaro);
    }
}