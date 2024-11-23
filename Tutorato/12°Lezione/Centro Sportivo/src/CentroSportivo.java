import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CentroSportivo {
    private ArrayList<Attivita> attivita;
    private ArrayList<Utente> utenti;
    private ArrayList<Prenotazione> prenotazioni;
    private int ids1=0;
    private int ids2=0;
    public CentroSportivo() {
        attivita = new ArrayList<>();
        utenti = new ArrayList<>();
        prenotazioni = new ArrayList<>();
    }
    public void registraUtente(String nome, String email) {
        Utente u=new Utente(ids1,nome,email);
        ids1++;
        utenti.add(u);
    }
    public void prenota(Utente u, Attivita a) throws UtenteNonRegistratoException, AttivitaNonTrovataException, PrenotazioneNonDisponibileException, PrenotazioneDuplicataException {
        Prenotazione p=new Prenotazione(ids2,u,a);
        for(Prenotazione p1: prenotazioni) {
            if(p1.equals(p)) {
                throw new PrenotazioneDuplicataException();
            }
        }
        try {
            if(!utenti.contains(u)) {
                throw new UtenteNonRegistratoException();
            }
        }
        catch(UtenteNonRegistratoException e) {
            System.err.println(e.getMessage());
            return;
        }
        if(!attivita.contains(a)) {
            throw new AttivitaNonTrovataException();
        }
        try {
            if(!a.prenotaPosto()) {
                throw new PrenotazioneNonDisponibileException();
            }
        }
        catch(PrenotazioneNonDisponibileException e) {
            System.err.println(e.getMessage());
            return;
        }
        ids2++;
        prenotazioni.add(p);
    }
    public void stampaAttivita() {
        int i=1;
        for(Attivita a: attivita) {
            System.out.println("["+i+"] "+a.toString());
            i++;
        }
    }
    public void aggiungiAttivita(Attivita a) {
        attivita.add(a);
    }
    public boolean utenteEsiste(Utente u) {
        for(Utente u1: utenti) {
            if(u1.equals(u)) {
                return true;
            }
        }
        return false;
    }
    public Utente getUtente(Utente u) {
        for(Utente u1: utenti) {
            if(u1.equals(u)) {
                return u1;
            }
        }
        return null;
    }
    public Utente getUtente(int id) {
        for(Utente u1: utenti) {
            if(u1.getId() == id) {
                return u1;
            }
        }
        return null;
    }
    public Attivita getAttivita(int i) {
        return attivita.get(i-1);
    }
    public Attivita getAttivita(String nome) {
        for(Attivita a: attivita) {
            if(a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }
    public void rimuoviPrenotazione(int i) {
        if(i>prenotazioni.size() || i<0) {
            throw new IndexOutOfBoundsException("Index fuori dal limite delle prenotazioni");
        }
        prenotazioni.get(i).getAttivita().ripristinaPosto();
        prenotazioni.remove(i);
    }
    public void saveUtenti() throws IOException {
        File file = new File("utenti.txt");
        if(file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter("utenti.txt");
        for(Utente u: utenti) {
            fw.write(u.toString()+"\n");
        }
        fw.close();
    }
    public void savePrenotazioni() throws IOException {
        File file = new File("prenotazioni.txt");
        if(file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter("prenotazioni.txt");
        for(Prenotazione p: prenotazioni) {
            fw.write(p.toString()+"\n");
        }
        fw.close();
    }
    public void saveAttivita() throws IOException {
        File file = new File("attivita.txt");
        if(file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter("attivita.txt");
        for(Attivita a: attivita) {
            fw.write(a.toStringForFile()+"\n");
        }
        fw.close();
    }
    public void saveAll() throws IOException {
        saveUtenti();
        savePrenotazioni();
        saveAttivita();
    }

    public ArrayList<Attivita> getAttivita() {
        return attivita;
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void loadFromFiles() throws FileNotFoundException {
        Scanner sc = null;
        File fileA = new File("attivita.txt");
        File fileP = new File("prenotazioni.txt");
        File fileU = new File("utenti.txt");
        if(!fileA.exists()) {
            throw new FileNotFoundException("Il file delle attività non esiste");
        }
        if(!fileP.exists()) {
            throw new FileNotFoundException("Il file delle prenotazioni non esiste");
        }
        if(!fileU.exists()) {
            throw new FileNotFoundException("Il file degli utenti non esiste");
        }
        sc = new Scanner(fileU);
        while(sc.hasNextLine() && sc.hasNextInt()) {
            int id = sc.nextInt();
            String nome = sc.next();
            String email = sc.next();
            utenti.add(new Utente(id,nome,email));
            ids1++;
        }
        sc = new Scanner(fileA);
        while(sc.hasNextLine() && sc.hasNext()) {
            String nome = sc.next();
            int available = sc.nextInt();
            attivita.add(new Attivita(nome,available));
        }
        sc = new Scanner(fileP);
        while(sc.hasNextLine() && sc.hasNextInt()) {
            int id = sc.nextInt();
            int userId = sc.nextInt();
            String nome = sc.next();
            ids2++;
            prenotazioni.add(new Prenotazione(id,getUtente(userId),getAttivita(nome)));
        }
    }
}

