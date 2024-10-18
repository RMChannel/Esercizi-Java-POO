import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("C:\\Users\\robbe\\IdeaProjects\\Archivio\\src\\file.txt");
        Scanner scanner=new Scanner(file);
        Archivio archivio=new Archivio();
        while (scanner.hasNextLine()) {
            String name=scanner.next();
            double price=Double.parseDouble(scanner.next());
            int quantity=scanner.nextInt();
            char type=scanner.next().charAt(0);
            archivio.addAction(new Action(name, price, quantity, type));
        }
        Action azioneTest=new Action("TESLA",22.5,400,'B');
        System.out.println("Somma degli importi delle azioni: "+archivio.getTotaleAzioni()+"\nImporto sulle azioni TESLA: "+ archivio.getInformazioneAzione(azioneTest));
        ArrayList<Action> listB=archivio.getAzioniTipologia('B');
        ArrayList<Action> listS=archivio.getAzioniTipologia('S');
        System.out.println("\nLista degli acquisti: ");
        for (Action a:listB) a.stampaAzione();
        System.out.println("\nLista delle vendite: ");
        for (Action a:listS) a.stampaAzione();
        Action azione=archivio.AzionePiùAlta();
        System.out.print("\nAzione alta: ");
        azione.stampaAzione();
        ArrayList<Action> listTrue=archivio.cercaRangeAzioni(20);
        System.out.println("\nLista delle azioni con importo minore a 20: ");
        for (Action a:listTrue) a.stampaAzione();
    }
}