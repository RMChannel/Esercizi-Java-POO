import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScegliModificaVolo {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton modificaVoloButton;
    private static JFrame frame;

    public ScegliModificaVolo() {
        frame = new JFrame("Scegli il volo da modificare");
        frame.setSize(600,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ModificaOEliminaVolo();
            }
        });
        modificaVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volo v=null;
                ArrayList<Volo> voli=GUI.getVoli();
                for(Volo volo:voli) {
                    if(("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime()).equals(comboBox1.getSelectedItem().toString())){
                        v=volo;
                        break;
                    }
                }
                frame.dispose();
                new ModificaVolo(v);
            }
        });
    }

    private void createUIComponents() {
        ArrayList<Volo> voli=GUI.getVoli();
        comboBox1 = new JComboBox();
        for(Volo volo:voli) {
            comboBox1.addItem("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime());
        }
    }
}
