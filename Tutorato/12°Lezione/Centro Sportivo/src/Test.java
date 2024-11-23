import java.io.IOException;

public class Test {
    public static void main(String[] args) throws PrenotazioneDuplicataException, AttivitaNonTrovataException, PrenotazioneNonDisponibileException, UtenteNonRegistratoException, IOException {
        CentroSportivo c = new CentroSportivo();
        Attivita a1=new Attivita("Calcetto",0);
        Attivita a2=new Attivita("Pallavolo",1);
        Attivita a3=new Attivita("Pallavolo",1);
        Attivita a4=new Attivita("Basket",50);
        Utente u=new Utente(0,"Roberto","robbencito@gmail.com");
        c.aggiungiAttivita(a1);
        c.aggiungiAttivita(a3);
        c.aggiungiAttivita(a4);
        c.prenota(u,a1);
        c.registraUtente("Roberto","robbencito@gmail.com");
        c.prenota(u,a1);
        c.prenota(u,a3);
        try {
            c.prenota(u,a3);
        }
        catch (PrenotazioneDuplicataException e) {
            System.out.println("Errore prenotazione duplicata avvenuto con successo");
        }
        try {
            c.prenota(u,a2);
        }
        catch (AttivitaNonTrovataException e) {
            System.out.println("Errore attività non trovata avvenuto con successo");
        }
        System.out.println("Numero posti disponibili attività prenotata: "+a3.getAvailable());
        c.saveAll();
    }
}
