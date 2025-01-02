package GUI.GestionePrenotazione;

import GUI.GUI;
import Hotel.Cliente;
import Hotel.Prenotazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionePrenotazione extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JTextField nome;
    private JTextField cognome;
    private JTextField telefono;
    private JButton cercaPrenotazioneButton;

    public GestionePrenotazione() {
        setTitle("Ricerca Prenotazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUI();
            }
        });
        cercaPrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nome.getText().isEmpty() || cognome.getText().isEmpty() || telefono.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Uno dei parametri è vuoto, controlla e riprova", "Errore parametro vuoto", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for(Cliente c:GUI.getClienti()) {
                    if(c.getNome().equals(nome.getText()) && c.getCognome().equals(cognome.getText()) && c.getTelefono().equals(telefono.getText())){
                        for(Prenotazione p:GUI.getPrenotazioni()) {
                            if(p.getCliente().equals(c)){
                                dispose();
                                new OpzioniPrenotazione(p);
                                return;
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,"Cliente non trovato","Errore cliente", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
