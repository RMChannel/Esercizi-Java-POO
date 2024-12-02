import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class AggiungiPasseggero {
    private JButton tornaIndietroButton;
    private JPanel panel;
    private JTextField nome;
    private JTextField cognome;
    private JTextField nPassaporto;
    private JButton creaPasseggeroButton;
    private JTextField dataDiNascita;
    private JTextField ID;
    private static JFrame frame;

    public AggiungiPasseggero() {
        frame = new JFrame("Aggiungi Passeggero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestionePasseggeri();
            }
        });
        creaPasseggeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nome.getText().isEmpty() || cognome.getText().isEmpty() || nPassaporto.getText().isEmpty() || dataDiNascita.getText().isEmpty() || ID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Uno dei dati è mancante, controlla e riprova","Errore parametri",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    GregorianCalendar data=new GregorianCalendar();
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String start = dataDiNascita.getText();
                        data.setTime(format.parse(start));
                    }
                    catch (ParseException exception) {
                        JOptionPane.showMessageDialog(frame, "La data non è stata scritta correttamente, controlla e riprova","Errore data",JOptionPane.ERROR_MESSAGE);
                    }
                    GUI.aggiungiPasseggero(new Passeggero(nome.getText(),cognome.getText(),data,Integer.parseInt(ID.getText()),Integer.parseInt(nPassaporto.getText())));
                    JOptionPane.showMessageDialog(frame,"Passeggero aggiunto correttamente","Passeggero aggiunto",JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new GUI();
                }
            }
        });
    }
}
