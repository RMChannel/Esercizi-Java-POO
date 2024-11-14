import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SlittaDiBabboNatale s=new SlittaDiBabboNatale(1000);
        RegaloAdulto r1=new RegaloAdulto(new GregorianCalendar(2024,12,25),30,"Centro","Roberto");
        RegaloAdulto r2=new RegaloAdulto(new GregorianCalendar(2024,12,25),30,"Sud","Laura");
        RegaloAdulto r3=new RegaloAdulto(new GregorianCalendar(2024,12,25),30,"Nord","Antonia");
        RegaloBambino r4=new RegaloBambino(new GregorianCalendar(2024,12,25),12,"Nord","Giovanni",6,"Buon Natale!!!");
        RegaloBambino r5=new RegaloBambino(new GregorianCalendar(2024,12,25),12,"Nord","Aleksandre",6,"Buon Natale!!!");
        s.aggiungiRegalo(r1);
        s.aggiungiRegalo(r2);
        s.aggiungiRegalo(r3);
        s.aggiungiRegalo(r4);
        s.aggiungiRegalo(r5);
        File file=new File("bambini.txt");
        FileWriter fw=new FileWriter(file);
        for(Object obj : s.getLista()) {
            if(obj.getClass().equals(RegaloBambino.class)) {
                RegaloBambino rb=(RegaloBambino)obj;
                fw.write(rb.getNome()+"\n");
            }
        }
        fw.close();
        Scanner sc=new Scanner(System.in);
        System.out.print("Costo di consegna totale: "+s.calcolaCosto()+"\n"+s.spedisci()+"\n\nInserisci il nome di un bambino da cercare: ");
        String nome=sc.nextLine();
        String line="";
        boolean flag=true;
        sc=new Scanner(file);
        while(sc.hasNextLine()) {
            line=sc.nextLine();
            try {
                if(line.equals(nome)) {
                    System.out.println("Bambino trovato");
                    flag=false;
                }
            }
            catch(NullPointerException e) {};
        }
        if(flag) System.out.println("Bambino non trovato");
    }
}