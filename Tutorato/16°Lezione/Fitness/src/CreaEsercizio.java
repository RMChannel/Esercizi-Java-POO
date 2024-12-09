import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaEsercizio extends JFrame {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JTextField nomeText;
    private JTextField durataText;
    private JTextField ripetizioniText;
    private JRadioButton facileRadioButton;
    private JRadioButton medioRadioButton;
    private JRadioButton difficileRadioButton;
    private JTextField descrizioneText;
    private JButton creaEsercizioButton;
    private JRadioButton cardioRadioButton;
    private JRadioButton forzaRadioButton;
    private JRadioButton stretchingRadioButton;
    private JLabel labelEdit;
    private JTextField editText;
    private static JFrame frame;

    public CreaEsercizio() {
        labelEdit.setText("Velocità:");
        frame = new JFrame();
        frame.setTitle("Aggiungi un nuovo esercizio");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup.add(facileRadioButton);
        buttonGroup.add(medioRadioButton);
        buttonGroup.add(difficileRadioButton);
        buttonGroup2.add(stretchingRadioButton);
        buttonGroup2.add(cardioRadioButton);
        buttonGroup2.add(forzaRadioButton);
        facileRadioButton.setSelected(true);
        cardioRadioButton.setSelected(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaEsercizi();
            }
        });
        creaEsercizioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nomeText.getText().isEmpty() || durataText.getText().isEmpty() || ripetizioniText.getText().isEmpty() || descrizioneText.getText().isEmpty() || editText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Uno dei parametri è vuoto, controlla e riprova","Errore parametri vuoti",JOptionPane.ERROR_MESSAGE);
                }
                double durata;
                int ripetizioni;
                try {
                    durata = Double.parseDouble(durataText.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame,"Il valore inserito in durata non è corretto","Errore durata",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ripetizioni = Integer.parseInt(ripetizioniText.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame,"Il valore inserito in ripetizioni non è corretto","Errore ripetizioni",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int difficoltà;
                if(difficileRadioButton.isSelected()) {
                    difficoltà=3;
                }
                else if(medioRadioButton.isSelected()) {
                    difficoltà=2;
                }
                else {
                    difficoltà=1;
                }
                if(cardioRadioButton.isSelected()) {
                    double velocità;
                    try {
                        velocità = Double.parseDouble(editText.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(frame,"Il valore di velocità è errato, controlla e riprova","Errore velocità",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Cardio c=new Cardio(nomeText.getText(),durata,ripetizioni,difficoltà,descrizioneText.getText(),velocità);
                    GUI.aggiungiEsercizio(c);
                }
                else if(forzaRadioButton.isSelected()) {
                    double peso;
                    try {
                        peso = Double.parseDouble(descrizioneText.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(frame,"Il valore di peso è errato, controlla e riprova","Errore peso",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Forza f=new Forza(nomeText.getText(),durata,ripetizioni,difficoltà,descrizioneText.getText(),peso);
                    GUI.aggiungiEsercizio(f);
                }
                else {
                    double tempoRecupero;
                    try {
                        tempoRecupero = Double.parseDouble(descrizioneText.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(frame,"Il valore di tempo di recupero è errato, controlla e riprova","Errore tempo di recupero",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Streching s=new Streching(nomeText.getText(),durata,ripetizioni,difficoltà,descrizioneText.getText(),tempoRecupero);
                    GUI.aggiungiEsercizio(s);
                }
                JOptionPane.showMessageDialog(frame,"Esercizio aggiunto correttamente");
                frame.dispose();
                new GUI();
            }
        });
        cardioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelEdit.setText("Velocità:");
            }
        });
        forzaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelEdit.setText("Peso:");
            }
        });
        stretchingRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelEdit.setText("Tempo di recupero:");
            }
        });
    }
}
