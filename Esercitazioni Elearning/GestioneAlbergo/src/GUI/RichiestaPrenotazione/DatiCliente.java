package GUI.RichiestaPrenotazione;

import GUI.GUI;
import Hotel.Cliente;
import Hotel.Stanza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class DatiCliente extends JFrame {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JTextField numeroDiTelefonoTextField;
    private JTextField numeroCartaTextField;
    private JButton creaPrenotazioneButton;

    public DatiCliente(GregorianCalendar checkin, GregorianCalendar checkout, Stanza stanza) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setTitle("Dati Cliente");
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MostraStanze(checkin,checkout,stanza.getTipologia());
            }
        });
        creaPrenotazioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nomeTextField.getText().isEmpty() || cognomeTextField.getText().isEmpty() || numeroDiTelefonoTextField.getText().isEmpty() || numeroCartaTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Uno dei parametri è vuoto, controlla e riprova", "Errore parametri vuoti", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(numeroDiTelefonoTextField.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Il numero di telefono non è valido", "Errore di numero di telefono", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    Integer.parseInt(numeroDiTelefonoTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Il numero di telefono non è valido", "Errore di numero di telefono", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(numeroCartaTextField.getText().length() != 16) {
                    JOptionPane.showMessageDialog(null,"Il numero di carta non è valido","Errore di numero di carta", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    Integer.parseInt(numeroCartaTextField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Il numero di carta non è valido","Errore di numero di carta", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GUI.addPrenotazione(checkin,checkout,new Cliente(nomeTextField.getText(),cognomeTextField.getText(),numeroDiTelefonoTextField.getText(),numeroCartaTextField.getText()),stanza);
                dispose();
                JOptionPane.showMessageDialog(null,"Prenotazione creata con successo","Prenotazione creata", JOptionPane.INFORMATION_MESSAGE);
                new GUI();
            }
        });
    }
}
