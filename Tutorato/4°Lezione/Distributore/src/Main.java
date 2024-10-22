public class Main {
    public static void main(String[] args) {
        Distributore distributore=new Distributore("Santa Maria a Vico", "Aleksandre Chickviladze",300,"Diesel");
        System.out.println("Città: "+distributore.città+"\nProprietario: "+distributore.proprietario+"\nLitri disponibili: "+distributore.litri());
        distributore.aggiungi(200);
        distributore.aggiungi(300);
        distributore.rifornisci(50);
        distributore.rifornisci(100);
        System.out.println("Ricavi-spese= "+distributore.ricavo());
    }
}