package GUI.RichiestaPrenotazione;

import GUI.GUI;
import Hotel.Prenotazione;
import Hotel.Stanza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;

public class MostraStanze extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JComboBox listaStanze;
    private JTextArea textArea;
    private JButton prenota;

    public MostraStanze(GregorianCalendar checkin, GregorianCalendar checkout, int tipo) {
        setTitle("Scegli una stanza:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        filterStanze(checkin,checkout,tipo);
        printStanza(Integer.parseInt(Objects.requireNonNull(listaStanze.getSelectedItem()).toString().substring(9)));
        setContentPane(panel);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RichiestaPrenotazione(checkin,checkout,tipo);
            }
        });
        listaStanze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printStanza(Integer.parseInt(Objects.requireNonNull(listaStanze.getSelectedItem()).toString().substring(9)));
            }
        });
        prenota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Stanza stanza = null;
                for(Stanza s: GUI.getStanze()) {
                    if(s.getNumero()==Integer.parseInt(Objects.requireNonNull(listaStanze.getSelectedItem()).toString().substring(9))) {
                        stanza = s;
                        break;
                    }
                }
                dispose();
                new DatiCliente(checkin,checkout,stanza);
            }
        });
    }

    public void filterStanze(GregorianCalendar checkin, GregorianCalendar checkout, int tipo) {
        ArrayList<Stanza> stanze = new ArrayList<Stanza>();
        for(Stanza s:GUI.getStanze()) {
            if(tipo==s.getTipologia()) {
                stanze.add(s);
            }
        }
        for(Stanza s:stanze) {
            for(Prenotazione p:GUI.getPrenotazioni()) {
                if(p.getStanza().equals(s) && p.getCheckout().compareTo(checkin)>=0) {
                    stanze.remove(s);
                }
            }
        }
        if(stanze.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nessuna stanza presente");
        }
        else {
            for(Stanza s:stanze) {
                listaStanze.addItem("Stanza n°"+s.getNumero());
            }
        }
    }

    public void printStanza(int numero) {
        for(Stanza stanza:GUI.getStanze()) {
            if(stanza.getNumero()==numero) {
                textArea.setText("Numero: " + stanza.getNumero()+"\nPiano: " + stanza.getPiano()+"\nServizi: " + stanza.getServizi()+"\nNumero di telefono: "+stanza.getTelefono());
            }
        }
    }
}
