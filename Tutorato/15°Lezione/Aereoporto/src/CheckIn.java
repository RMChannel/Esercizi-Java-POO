import javax.swing.*; //TODO
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckIn {
    private JPanel checkIn;
    private JButton tornaIndietroButton;
    private JPanel panel;
    private JComboBox listaVoli;
    private JLabel scegliIlVoloInLabel;
    private JLabel ScegliIlPasseggeroLabel;
    private JComboBox listaPasseggeri;
    private JButton faiIlCheckInButton;
    private static JFrame frame;

    public CheckIn() {
        frame = new JFrame();
        frame.setContentPane(checkIn);
        frame.setTitle("CheckIn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        faiIlCheckInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volo v=null;
                Passeggero p=null;
                ArrayList<Persona> persone=GUI.getPersone();
                for(Persona persona:persone){
                    if(persona.getClass()==Passeggero.class && persona.toString().equals(listaPasseggeri.getSelectedItem().toString())){
                        p=(Passeggero)persona;
                        break;
                    }
                }
                ArrayList<Volo> voli=GUI.getVoli();
                for(Volo volo:voli) {
                    if(("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime()).equals(listaVoli.getSelectedItem().toString())){
                        v=volo;
                        break;
                    }
                }
                try {
                    GUI.checkIn(p,v);
                }
                catch (CheckInAlreadyDone exception) {
                    JOptionPane.showMessageDialog(frame, exception.getMessage(), "Errore check-in", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(frame,"Check-in effettuato correttamente","Check-in confirmed",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                new GUI();
            }
        });
    }

    private void createUIComponents() {
        listaPasseggeri=new JComboBox();
        listaVoli=new JComboBox();
        ArrayList<Persona> persone=GUI.getPersone();
        for(Persona persona:persone) {
            if(persona.getClass()==Passeggero.class) {
                listaPasseggeri.addItem(persona.toString());
            }
        }
        ArrayList<Volo> voli=GUI.getVoli();
        for(Volo volo:voli) {
            listaVoli.addItem("Codice: "+volo.getCodice()+" Destinazione: "+volo.getDestinazione()+" Orario di partenza: "+ volo.getOrarioDiPartenza().getTime());
        }
    }
}
