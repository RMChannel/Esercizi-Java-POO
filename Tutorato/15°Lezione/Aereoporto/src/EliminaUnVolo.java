import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminaUnVolo {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JComboBox comboVoli;
    private JButton eliminaIlVoloButton;
    private static JFrame frame;

    public EliminaUnVolo() {
        frame=new JFrame("Elimina un volo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 200);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ModificaOEliminaVolo();
            }
        });
        eliminaIlVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volo v=null;
                ArrayList<Volo> voli=GUI.getVoli();
                for(Volo volo:voli) {
                    if(("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime()).equals(comboVoli.getSelectedItem().toString())){
                        v=volo;
                        break;
                    }
                }
                GUI.rimuoviVolo(v);
                JOptionPane.showMessageDialog(frame, "Volo rimosso con successo");
                frame.dispose();
                new GUI();
            }
        });
    }

    private void createUIComponents() {
        comboVoli = new JComboBox();
        ArrayList<Volo> voli=GUI.getVoli();
        for(Volo volo:voli) {
            comboVoli.addItem("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime());
        }
    }
}
