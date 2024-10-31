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
        s1.printScommessa();
        System.out.println("Vincita: "+s1.calcolaVincita(true)+"\n");
        s2.printScommessa();
        System.out.println("Vincita: "+s2.calcolaVincita(true)+"\n");
        s3.printScommessa();
        System.out.println("Vincita: "+s3.calcolaVincita(true)+"\n");
    }
}