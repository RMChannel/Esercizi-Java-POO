import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CercaPerCodice {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JTextField codice;
    private JButton cercaButton;
    private static JFrame frame;

    public CercaPerCodice() {
        JFrame frame = new JFrame();
        frame.setTitle("Cerca per codice");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int code = 0;
                try {
                    code = Integer.parseInt(codice.getText());
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(frame, "Codice non valido", "Errore codice", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ArrayList<Persona> persone=GUI.getPersone();
                for(Persona p:persone) {
                    if(p.getClass()==Passeggero.class) {
                        if(p.getId()==code) {
                            JOptionPane.showMessageDialog(frame, "La persona è stata trovata:\nNome: "+p.getNome()+"\nCognome: "+p.getCognome());
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(frame, "Codice non valido, persona non trovata", "Errore codice", JOptionPane.ERROR_MESSAGE);

            }
        });
    }
}
