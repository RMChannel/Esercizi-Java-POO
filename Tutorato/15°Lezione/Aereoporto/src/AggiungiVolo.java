import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AggiungiVolo {
    private JButton tornaIndietroButton;
    private JPanel panel;
    private JTextField codice;
    private JComboBox aereo;
    private JTextField destinazione;
    private JTextField orarioDiPartenza;
    private JTextField orarioDiArrivo;
    private JRadioButton pa;
    private JButton creaVoloButton;
    private JRadioButton inArrivoRadioButton;
    private static JFrame frame;

    public AggiungiVolo() {
        frame = new JFrame();
        frame.setTitle("Aggiungi volo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        pa.setSelected(true);
        buttonGroup.add(pa);
        buttonGroup.add(inArrivoRadioButton);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestioneVoli();
            }
        });
        creaVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(codice.getText().isEmpty() || destinazione.getText().isEmpty() || orarioDiPartenza.getText().isEmpty() || orarioDiArrivo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Uno dei campi è vuoto, controlla e riprova","Errore campi vuoti",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Aereo plane=null;
                    ArrayList<Aereo> aerei=GUI.getAerei();
                    for(Aereo a:aerei) {
                        if(aereo.getSelectedItem().equals(a.toString())) {
                            plane=a;
                            break;
                        }
                    }
                    if(plane==null) throw new IllegalArgumentException("L'aereo, in modo inspiegabilmente strano, non è stato trovato");
                    GregorianCalendar op=new GregorianCalendar();
                    GregorianCalendar oa=new GregorianCalendar();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    try {
                        op.setTime(format.parse(orarioDiPartenza.getText()));
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame,"La data dell'orario di partenza non è stata scritta correttamente, controlla e riprova","Errore orario di partenza",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        oa.setTime(format.parse(orarioDiArrivo.getText()));
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame,"La data nell'orario di arrivo non è stata scritta correttamente, controlla e riprova","Errore orario di arrivo",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    boolean paReal;
                    if(pa.isSelected()) {
                        paReal=true;
                    }
                    else {
                        paReal=false;
                    }
                    GUI.aggiungiVolo(codice.getText().toUpperCase(),plane,destinazione.getText(),op,oa,paReal);
                    JOptionPane.showMessageDialog(frame,"Volo aggiunto correntamente","Volo aggiunto",JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new GUI();
                }
            }
        });
    }

    private void createUIComponents() {
        aereo = new JComboBox();
        ArrayList<Aereo> aerei=GUI.getAerei();
        for(Aereo a:aerei) {
            aereo.addItem(a.toString());
        }
    }
}
