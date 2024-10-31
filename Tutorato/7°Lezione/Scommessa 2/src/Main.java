import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scommessa s1=new ScommessaCalcistica("AC12CA3",500,3.0,"Serie A","Casertana","Salernitana");
        Cavalli cavalli=new Cavalli();
        cavalli.Add("Giovanni");
        cavalli.Add("Lucio");
        cavalli.Add("Giorgio");
        Scommessa s2= new ScommessaIppica("CBH124VCS",300,2.3,"Trotto",2,cavalli);
        cavalli=new Cavalli();
        cavalli.Add("Giovanni");
        Scommessa s3= new ScommessaIppica("XQQ13MCV",200,2.3,"Galoppo",1,cavalli);
        SistemaScommesse ss=new SistemaScommesse();
        ss.aggiungiScommessa(s1);
        ss.aggiungiScommessa(s2);
        ss.aggiungiScommessa(s3);
        System.out.println("Tipo scomessa 1°scommessa: "+ss.daiTipoScommessa(0)+"\n");
        System.out.println("Scommessa minima");
        ss.getMinimo().printScommessa();
        System.out.println("Vincita minima: "+ss.getMinimo().calcolaVincita(true)+"\n");
        System.out.println("\nScommessa massima");
        ss.getMassimo().printScommessa();
        System.out.println("Vincita massima: "+ss.getMassimo().calcolaVincita(true)+"\n");
        System.out.println("\nVincita totale: "+ss.calcolaVincita()+"\n");
        ArrayList<Scommessa> risultatiRicerca=ss.cerca("ippica");
        for(Scommessa s:risultatiRicerca){
            s.printScommessa();
            System.out.println();
        }
    }
}