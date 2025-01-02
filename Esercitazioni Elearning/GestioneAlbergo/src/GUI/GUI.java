package GUI;

import GUI.GestionePrenotazione.GestionePrenotazione;
import GUI.RichiestaPrenotazione.RichiestaPrenotazione;
import Hotel.Cliente;
import Hotel.Prenotazione;
import Hotel.Stanza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GUI extends JFrame {
    private static ArrayList<Cliente> clienti;
    private static ArrayList<Stanza> stanze;
    private static ArrayList<Prenotazione> prenotazioni;
    private JPanel panel;
    private JButton richiestaPrenotazioneButton;

    public static ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public static ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public static ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public static void rimuoviPrenotazione(Prenotazione prenotazione) {
        clienti.remove(prenotazione.getCliente());
        prenotazioni.remove(prenotazione);
    }

    private JButton gestionePrenotazioneButton;

    private void buildGUI() {
        this.setTitle("Gestione Albergo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,100);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);
        richiestaPrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RichiestaPrenotazione();
            }
        });
        gestionePrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionePrenotazione();
            }
        });
    }

    public GUI(ArrayList<Cliente> clienti, ArrayList<Stanza> stanze, ArrayList<Prenotazione> prenotazione) {
        GUI.clienti = clienti;
        GUI.stanze = stanze;
        GUI.prenotazioni = prenotazione;
        checkCheckOut();
        buildGUI();
    }

    public GUI() {
        checkCheckOut();
        buildGUI();
    }

    public static void checkCheckOut() {
        ArrayList<Prenotazione> temp=new ArrayList<Prenotazione>();
        for(Prenotazione pr : prenotazioni){
            if(pr.getCheckout().compareTo(new GregorianCalendar())<0) {
                temp.add(pr);
            }
        }
        for(Prenotazione pr : temp){
            clienti.remove(pr.getCliente());
            prenotazioni.remove(pr);
        }
    }

    public static void addPrenotazione(GregorianCalendar checkin, GregorianCalendar checkout, Cliente cliente, Stanza stanza) {
        prenotazioni.add(new Prenotazione(checkin,checkout,cliente,stanza));
    }
}
