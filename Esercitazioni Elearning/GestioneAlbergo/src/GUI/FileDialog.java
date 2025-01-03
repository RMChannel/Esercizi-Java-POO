package GUI;

import Hotel.Cliente;
import Hotel.Prenotazione;
import Hotel.Stanza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileDialog extends JFrame {
    private ArrayList<Cliente> clienti;
    private ArrayList<Stanza> stanze;
    private ArrayList<Prenotazione> prenotazione;
    private JTextField nomeFile;
    private JButton apriFileButton;
    private JPanel panel;

    public FileDialog() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Open File");
        setSize(300,100);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        apriFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(nomeFile.getText());
                if(!file.exists()) {
                    JOptionPane.showMessageDialog(null, "File non trovato", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    clienti = (ArrayList<Cliente>) ois.readObject();
                    stanze = (ArrayList<Stanza>) ois.readObject();
                    prenotazione = (ArrayList<Prenotazione>) ois.readObject();
                    ois.close();
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(null, "File non letto correttamente, riscrivere il file", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                    return;
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Oggetti non salvati correttamente", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                    return;
                }
                dispose();
                new GUI(clienti, stanze, prenotazione);
            }
        });
    }

    public static void main(String[] args) {
        new FileDialog();
    }
}
