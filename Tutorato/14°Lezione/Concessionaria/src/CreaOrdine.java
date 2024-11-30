import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreaOrdine {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JComboBox checkVeicolo;
    private JComboBox checkCliente;
    private JButton creaOrdineButton;
    private static JFrame frame;
    private static ArrayList<Veicolo> veicoli;
    private static ArrayList<Cliente> clienti;
    public CreaOrdine(ArrayList<Veicolo> v, ArrayList<Cliente> c) {
        frame = new JFrame();
        clienti = c;
        veicoli = v;
        createUIComponents();
        frame.setTitle("Crea ordine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setContentPane(panel1);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI.main(null);
            }
        });
        creaOrdineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GUI.addOrdine(clienti.get(checkCliente.getSelectedIndex()), veicoli.get(checkVeicolo.getSelectedIndex()));
                    JOptionPane.showMessageDialog(frame,"Il veicolo è stato ordinato correttamente","Veicolo ordinato",JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    GUI.main(null);
                }
                catch(IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage(), "Il veicolo non è presente nel concessionario", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalCallerException e2) {
                    JOptionPane.showMessageDialog(frame,e2.getMessage(),"Veicolo già ordinato",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void createUIComponents() {
        for(Veicolo v : veicoli) {
            checkVeicolo.addItem(v.getMarca()+" "+v.getModello());
        }
        for(Cliente c : clienti) {
            checkCliente.addItem(c.getNome()+" "+c.getCognome());
        }
    }
}
