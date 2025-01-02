package GUI.GestionePrenotazione;

import GUI.GUI;
import Hotel.Prenotazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpzioniPrenotazione extends JFrame {
    private JPanel panel;
    private JButton modificaPrenotazioneButton;
    private JButton cancellaPrenotazioneButton;
    private JButton tornaIndietroButton;

    public OpzioniPrenotazione(Prenotazione prenotazione) {
        setTitle("Prenotazione "+prenotazione.getCliente().getNome()+" "+prenotazione.getCliente().getCognome()+" "+prenotazione.getStanza().getNumero());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionePrenotazione();
            }
        });
        modificaPrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ModificaPrenotazione(prenotazione);
            }
        });
        cancellaPrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null,"Sei sicuro di voler cancellare la prenotazione?") == 0) {
                    dispose();
                    GUI.rimuoviPrenotazione(prenotazione);
                    JOptionPane.showMessageDialog(null,"Prenotazione cancellata","Conferma rimozione prenotazione e cliente",JOptionPane.INFORMATION_MESSAGE);
                    new GUI();
                }
            }
        });
    }
}
