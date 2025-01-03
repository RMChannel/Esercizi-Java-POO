import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrenotazioneGUI extends JFrame {
    private JPanel panel;
    private JTextField nome;
    private JTextField cognome;
    private JTextField eta;
    private JComboBox<String> comboBox1;
    private JButton prenotaButton;

    public PrenotazioneGUI(String codice, Seat seat) {
        setTitle("Prenotazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        prenotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nome.getText().isEmpty() || cognome.getText().isEmpty() || eta.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Uno dei parametri è vuoto, controlla e riprova", "Errore parametri vuoti", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int età=0;
                try {
                    Integer.parseInt(eta.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "L'età non è stata scritta correttamente, controlla e riprova", "Errore età", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Prenotazione p=new Prenotazione(nome.getText(),cognome.getText(),età,codice,comboBox1.getSelectedIndex()+1,seat);
                seat.setOccupato(true);
                JOptionPane.showMessageDialog(null, p.toString(), "Prenotazione effettuata con successo", JOptionPane.PLAIN_MESSAGE);
                dispose();
                new MainGUI();
            }
        });
    }
}
