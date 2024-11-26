import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RealProgram {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        Biblioteca b= new Biblioteca();
        int operation;
        String path;
        while (!done) {
            System.out.print("[1]Aggiungere un libro\n[2]Visualizzare tutti i libri\n[3]Salva la biblioteca su un file\n[4]Carica la biblioteca da un file\n[5]Cerca un libro per titolo o ISBN\n[0]Termina il programma\n\nScegli cosa vuoi fare: ");
            try {
                operation = sc.nextInt();
                sc.nextLine();
            }
            catch (Exception e) {
                System.err.print("Il parametro non è un intero, riprovare, premi invio per continuare\n");
                sc.nextLine();
                sc.nextLine();
                operation = -1;
            }
            switch (operation) {
                case -1:
                    break;
                case 0:
                    done = true;
                    break;
                case 1:
                    System.out.print("[1]Libro Standard\n[2]Libro di narrativa\n[3]Fumetto\n[4]Manuale\n\nChe libro vuoi aggiungere?: ");
                    operation = -1;
                    while(operation<1 || operation>4) {
                        operation = sc.nextInt();
                        if(operation<1 || operation>4) {
                            System.err.println("Valore non corretto, riprovare: ");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    System.out.print("Inserisci il titolo: ");
                    String titolo = sc.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    String autore = sc.nextLine();
                    System.out.print("Inserisci l'ISBN: ");
                    int ISBN = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Inserisci l'anno: ");
                    int anno = sc.nextInt();
                    sc.nextLine();
                    if(operation == 1) {
                        b.addLibro(new Libro(titolo, autore, ISBN, anno));
                    }
                    else if(operation == 2) {
                        System.out.print("Inserisci il genere: ");
                        String genere = sc.nextLine();
                        System.out.print("Inserisci la lingua: ");
                        String lingua = sc.nextLine();
                        System.out.print("Il libro è stato premiato?:\n[1]Si\n[Altro]No\n");
                        boolean premiato;
                        premiato= sc.nextInt() == 1;
                        sc.nextLine();
                        System.out.print("Inserisci il numero di capitoli: ");
                        int capitoli = sc.nextInt();
                        sc.nextLine();
                        b.addLibro(new LibroNarrativa(titolo,autore,ISBN,anno,genere,lingua,premiato,capitoli));
                    }
                    else if(operation == 3) {
                        System.out.print("Inserisci il disegnatore: ");
                        String disegnatore = sc.nextLine();
                        System.out.print("Inserisci la casa editrice: ");
                        String casa = sc.nextLine();
                        System.out.print("Inserisci il numero di pagine: ");
                        int pagine = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Inserisci il target: ");
                        String target = sc.nextLine();
                        System.out.print("Il fumetto fa parte di una serie?\n[1]Sì\n[Altro]No\n");
                        boolean serie;
                        serie= sc.nextInt() == 1;
                        sc.nextLine();
                        b.addLibro(new Fumetto(titolo,autore,ISBN,anno,disegnatore,casa,pagine,serie,target));
                    }
                    else {
                        System.out.print("Inserisci l'ambito: ");
                        String ambito = sc.nextLine();
                        System.out.print("Inserisci la difficoltà: ");
                        int difficoltà = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Inserisci l'edizione: ");
                        String edizione = sc.nextLine();
                        System.out.print("Ci sono esercizi nel manuale?\n[1]Sì\n[Altro]No\n");
                        boolean esercizi;
                        esercizi= sc.nextInt() == 1;
                        sc.nextLine();
                        b.addLibro(new Manuale(titolo,autore,ISBN,anno,ambito,difficoltà,edizione,esercizi));
                    }
                    System.out.print("\n\nLibro aggiunto\n\n");
                    break;
                case 2:
                    b.stampaLibri();
                    System.out.print("\n");
                    break;
                case 3:
                    System.out.print("Inserisci il nome con cui salvare il file: ");
                    path = sc.nextLine();
                    b.salva(path);
                    System.out.println("Salvataggio effettuato con successo\n");
                    break;
                case 4:
                    System.out.print("Inserisci il path del file che vuoi caricare: ");
                    path = sc.nextLine();
                    b=Biblioteca.load(path);
                    System.out.println("Caricamento effettuato con successo\n");
                    break;
                case 5:
                    System.out.println("Se vuoi cercare il libro per titolo, inserisci il titolo, altrimenti inserisci l'ISBN da cercare: ");
                    ArrayList<Libro> found;
                    if(sc.hasNextInt()) {
                        found=b.cerca(sc.nextInt());
                        sc.nextLine();
                    }
                    else {
                        found=b.cerca(sc.nextLine());
                    }
                    if(found.isEmpty()) {
                        System.out.println("Non è stato trovato nessun libro corrispondente");
                    }
                    else {
                        System.out.println("Ecco i libri corrispondenti trovati:");
                        for(Libro l:found) {
                            System.out.println(l.toString());
                        }
                    }
                    System.out.print("\nPremi invio per continuare: ");
                    sc.nextLine();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Il parametro inserito non è corretto, riprovare, premi invio per continuare\n");
                    sc.nextLine();
                    sc.nextLine();
            }
        }
    }
}