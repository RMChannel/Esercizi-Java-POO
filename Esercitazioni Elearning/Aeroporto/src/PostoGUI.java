import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PostoGUI extends JFrame {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton selezionaButton;

    public PostoGUI(String codice) {
        setTitle("Scegli un posto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 150);
        setLocationRelativeTo(null);
        ArrayList<Volo> voli=MainGUI.flightList.getVoli();
        Volo v=null;
        for(Volo volo : voli) {
            if(volo.getCodice().equals(codice)) {
                v=volo;
                break;
            }
        }
        for(Seat s:v.getPosti()) {
            if(!s.isOccupato()) {
                String str= String.valueOf(s.getNumero())+s.getPosizione();
                comboBox1.addItem(str);
            }
        }
        if(comboBox1.getSelectedItem()==null) {
            throw new RuntimeException("Non è disponibile nessun posto");
        }
        setContentPane(panel1);
        setVisible(true);
        Volo finalV = v;
        selezionaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Seat sTemp=null;
                for(Seat s: finalV.getPosti()) {
                    if(!s.isOccupato() && (String.valueOf(s.getNumero())+s.getPosizione()).equals(comboBox1.getSelectedItem().toString())) {
                        sTemp=s;
                        break;
                    }
                }
                new PrenotazioneGUI(codice,sTemp);
            }
        });
    }
}
