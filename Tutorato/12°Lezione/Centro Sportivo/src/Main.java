import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PrenotazioneDuplicataException, AttivitaNonTrovataException, PrenotazioneNonDisponibileException, UtenteNonRegistratoException, IOException {
        Scanner sc = new Scanner(System.in);
        CentroSportivo c = new CentroSportivo();
        Attivita a1=new Attivita("Calcetto",3);
        Attivita a2=new Attivita("Basket",2);
        Attivita a3=new Attivita("Pallavolo",1);
        c.aggiungiAttivita(a1);
        c.aggiungiAttivita(a2);
        c.aggiungiAttivita(a3);
        boolean ciclo = true;
        int scelta;
        String nome, email;
        while (ciclo) {
            System.out.println("Cosa vuoi fare?\n[1]Registrare un utente\n[2]Visualizzare le attività disponibili\n[3]Prenotare un'attività\n[Altro]Uscire");
            scelta=sc.nextInt();
            sc.nextLine();
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il tuo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Inserisci la tua email: ");
                    email = sc.nextLine();
                    c.registraUtente(nome, email);
                    break;
                case 2:
                    System.out.print("Inserisci il tuo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Inserisci la tua email: ");
                    email = sc.nextLine();
                    if(c.utenteEsiste(new Utente(1,nome,email))) {
                        c.stampaAttivita();
                    }
                    else {
                        System.out.println("L'utente non è registrato, registrati per visualizzare le attività");
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il tuo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Inserisci la tua email: ");
                    email = sc.nextLine();
                    Utente temp=new Utente(2,nome,email);
                    if(c.utenteEsiste(temp)) {
                        temp=c.getUtente(temp);
                        c.stampaAttivita();
                        System.out.println("Scegli l'attività da prenotare: ");
                        scelta=sc.nextInt();
                        Attivita a=c.getAttivita(scelta);
                        c.prenota(temp,a);
                    }
                    break;
                default:
                    ciclo = false;
                    c.saveUtenti();
                    c.savePrenotazioni();
                    c.saveAttivita();
            }
        }
    }
}