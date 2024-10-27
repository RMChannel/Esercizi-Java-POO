public class GestioneMoto {
    public static void main(String[] args) {
        Moto moto=new Moto("Yamaha","MT-07",2020,689,"NAKED");
        moto.aggiungiComponente(new Componente("Motore","Yamaha","CP2",2020,75,68));
        moto.aggiungiComponente(new Componente("Freni","Brembo","Serie Oro",2019,"Disco","Acciaio"));
        moto.aggiungiComponente(new Componente("Pneumatici","Michelin","Road 5",2020,"120/70 R17","Stradale"));
        moto.visualizzaDettagli();
    }
}