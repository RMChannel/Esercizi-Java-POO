import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreaAllenamento extends JFrame {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JPanel buttonPanel;
    private JButton creaAllenamentoButton;
    private static JFrame frame;
    private static ArrayList<Checkbox> checkboxes;
    private static ArrayList<JTextField> durate;
    private static ArrayList<JTextField> ripetizioni;
    private static ArrayList<Esercizio> esercizi;

    public CreaAllenamento() {
        frame.setTitle("Crea Allenamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaAllenamenti();
            }
        });
        creaAllenamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean control=true;
                ArrayList<Esercizio> esercizi2=new ArrayList<>();
                for(Checkbox checkbox : checkboxes) {
                    if(checkbox.getState()) {
                        control=false;
                        double durata=0;
                        int ripetizione=0;
                        if(durate.get(checkboxes.indexOf(checkbox)).getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame,"Il valore della durata dell'esercizio "+checkbox.getLabel()+" è vuoto","Errore durata",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else {
                            try {
                                durata=Double.parseDouble(durate.get(checkboxes.indexOf(checkbox)).getText());
                            } catch (NumberFormatException exception) {
                                JOptionPane.showMessageDialog(frame,"Il valore della durata dell'esercizio "+checkbox.getLabel()+" non è valido","Errore durata",JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        if(ripetizioni.get(checkboxes.indexOf(checkbox)).getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame,"Il valore delle ripetizioni dell'esercizio "+checkbox.getLabel()+" è vuoto","Errore ripetizioni",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        else {
                            try {
                                ripetizione=Integer.parseInt(ripetizioni.get(checkboxes.indexOf(checkbox)).getText());
                            } catch (NumberFormatException exception) {
                                JOptionPane.showMessageDialog(frame,"Il valore delle ripetizioni dell'esercizio "+checkbox.getLabel()+" non è valido","Errore ripetizioni",JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        Esercizio es=esercizi.get(checkboxes.indexOf(checkbox));
                        if(es.getClass()==Cardio.class) {
                            Cardio cardio=(Cardio)es;
                            esercizi2.add(new Cardio(cardio.getNome(),durata,ripetizione,cardio.getDifficoltà(),cardio.eseguiEsercizio(),cardio.getVelocità()));
                        }
                        else if(es.getClass()==Forza.class) {
                            Forza forza=(Forza)es;
                            esercizi2.add(new Forza(forza.getNome(),durata,ripetizione,forza.getDifficoltà(),forza.eseguiEsercizio(),forza.getPeso()));
                        }
                        else {
                            Streching streching=(Streching)es;
                            esercizi2.add(new Streching(streching.getNome(),durata,ripetizione,streching.getDifficoltà(),streching.eseguiEsercizio(),streching.getTempoRecupero()));
                        }
                    }
                }
                if(control) {
                    JOptionPane.showMessageDialog(frame,"Nessun esercizio è stato selezionato, controlla e riprova","Errore esercizi",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GUI.addAllenamento(new Allenamento(esercizi2));
                JOptionPane.showMessageDialog(frame,"Allenamento creato correttamente","Creazione allenamento effettuata",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new GUI();
            }
        });
    }

    private void createUIComponents() {
        buttonPanel = new JPanel();
        checkboxes = new ArrayList<>();
        durate = new ArrayList<>();
        ripetizioni = new ArrayList<>();
        esercizi=GUI.getEsercizi();
        buttonPanel.setLayout(new GridLayout(esercizi.size(),5));
        esercizi.sort(Esercizio::compareTo);
        for(Esercizio e:esercizi) {
            Checkbox button = new Checkbox(e.getNome());
            checkboxes.add(button);
            buttonPanel.add(button);
            buttonPanel.add(new JLabel("Durata: "));
            JTextField durata=new JTextField();
            buttonPanel.add(durata);
            durate.add(durata);
            buttonPanel.add(new JLabel("Ripetizione: "));
            JTextField ripetizione=new JTextField();
            buttonPanel.add(ripetizione);
            ripetizioni.add(ripetizione);
        }
    }
}
