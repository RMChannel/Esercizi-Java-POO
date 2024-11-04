public class Main {
    public static void main(String[] args) {
        Dipendente d1=new Dipendente("AC124",1500,100);
        DipendentePartTime d2=new DipendentePartTime("AC125",1100,50);
        DipendenteFullTime d3=new DipendenteFullTime("AC126",1800,200,0);
        DipendenteFullTime d4=new DipendenteFullTime("AC127",1800,200,30);
        System.out.println("Paga dipendente normale: "+d1.paga(30));
        System.out.println("Paga dipendente PartTime con 0 malattie: "+d2.paga(30));
        d2.prendiMalattia(15);
        System.out.println("Paga dipendente PartTime con 15 giorni di malattia: "+d2.paga(30));
        System.out.println("Paga dipendente FullTime senza buoni pasto e senza ferie: "+d3.paga(30));
        d3.setFerieUtilizzate(20);
        System.out.println("Paga dipendente FullTime senza buoni pasto e 20 ferie utilizzate: "+d3.paga(30));
        System.out.println(("Paga dipendente FullTime con 30 buoni pasto e senza ferie concesse: "+d4.paga(30)));
        d4.setFerieConcesse(20);
        System.out.println("Paga dipendente FullTime con 30 buoni pasto e 20 ferie concesse: "+d4.paga(30));
    }
}