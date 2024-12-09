import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainFromTerminal {
    public static void main(String[] args) throws IOException {
        ArrayList<Aeromobile> aeromobiles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++) {
            System.out.println("Inserisci il "+(i+1)+"°aeromobile, quale vuoi inserire?\n[1]Aeroplano\n[2]Elicottero");
            int scelta=sc.nextInt();
            if(scelta<1 || scelta>2) {
                System.err.println("Non hai inserito un valore corretto, riprova");
                continue;
            }
            GregorianCalendar dataDiScadenza = null;
            GregorianCalendar dataDiPartenza = null;
            boolean control=true;
            while (control) {
                System.out.print("Inserisci la data di scadenza della revisione (DD/MM/YYYY): ");
                try {
                    control=false;
                    String data=sc.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date=formatter.parse(data);
                    dataDiScadenza=new GregorianCalendar();
                    dataDiScadenza.setTime(date);
                } catch (ParseException e) {
                    System.err.println("Non hai inserito un valore corretto, riprova");
                    sc.nextLine();
                    control=true;
                }
            }
            control=true;
            while (control) {
                System.out.print("Inserisci la data di partenza del volo (DD/MM/YYYY): ");
                try {
                    control=false;
                    String data=sc.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date=formatter.parse(data);
                    dataDiPartenza=new GregorianCalendar();
                    dataDiPartenza.setTime(date);
                } catch (ParseException e) {
                    System.err.println("Non hai inserito un valore corretto, riprova");
                    sc.nextLine();
                    control=true;
                }
            }
            control=true;
            int numeroDiPasseggeri = 0;
            while (control) {
                System.out.print("Inserisci il numero di passeggeri prenotati: ");
                numeroDiPasseggeri=sc.nextInt();
                if(numeroDiPasseggeri<0) {
                    System.err.println("Non hai inserito un valore corretto, riprova");
                }
                else control=false;
            }
            if(scelta==1) {
                sc.nextLine();
                System.out.print("Inserisci il modello dell'aeroplano: ");
                String modello=sc.nextLine();
                System.out.print("Inserisci il codice del volo: ");
                String codice=sc.next();
                int durata = 0;
                control=true;
                while (control) {
                    System.out.print("Inserisci il durata del volo: ");
                    durata=sc.nextInt();
                    if(durata<=0) {
                        System.err.println("Non hai inserito un valore corretto, riprova");
                    }
                    else control=false;
                }
                String temp="";
                ArrayList<String> rotta=new ArrayList<>();
                System.out.println("Inserisci ogni città della rotta, per terminare inserisci 0");
                while(true) {
                    System.out.print("Inserisci la prossima città: ");
                    temp=sc.next();
                    if(temp.equals("0")) {
                        break;
                    }
                    else {
                        rotta.add(temp);
                    }
                }
                Aeroplano a= new Aeroplano(dataDiScadenza,dataDiPartenza,numeroDiPasseggeri,modello,codice,rotta,durata);
                try {
                    for(Aeromobile aeromobile:aeromobiles) {
                        if(aeromobile.getClass()==Aeromobile.class) {
                            if(aeromobile.equals(a)) {
                                throw new RuntimeException();
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    System.err.println("Sono stati creati due aerei identici, riprova");
                    i--;
                    continue;
                }
                aeromobiles.add(a);
            }
            else {
                System.out.print("Inserisci la destinazione: ");
                String destinazione=sc.next();
                System.out.print("Inserisci l'identificativo: ");
                String identificativo=sc.next();
                Elicottero a = new Elicottero(dataDiScadenza,dataDiPartenza,numeroDiPasseggeri,destinazione,identificativo);
                try {
                    for(Aeromobile aeromobile:aeromobiles) {
                        if(aeromobile.getClass()==Elicottero.class) {
                            Elicottero temp=(Elicottero)aeromobile;
                            if(temp.equals(a)) {
                                throw new RuntimeException();
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    System.err.println("Sono stati creati due aerei identici, riprova");
                    i--;
                    continue;
                }
                aeromobiles.add(a);
            }
        }
        System.out.println("Vuoi salvare gli aeromobili?\n[1]Si\n[Altro]No");
        int scelta=sc.nextInt();
        if(scelta==1) {
            File file=new File("save.dat");
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
            for(Aeromobile aeromobile:aeromobiles) {
                oos.writeObject(aeromobile);
            }
            System.out.println("Salvataggio areomobili effettuato");
        }
        else {
            System.out.println("Programma terminato senza salvataggio");
        }
    }
}
