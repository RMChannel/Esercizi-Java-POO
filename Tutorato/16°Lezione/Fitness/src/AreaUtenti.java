import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AreaUtenti extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JComboBox comboBox1;
    private JButton apriStatisticheUtenteButton;
    private static JFrame frame;

    public AreaUtenti() {
        frame = new JFrame();
        frame.setTitle("Area Utenti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        apriStatisticheUtenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cliente> clienti = GUI.getClienti();
                frame.dispose();
                new StatisticheUtente(clienti.get(comboBox1.getSelectedIndex()));
            }
        });
    }

    private void createUIComponents() {
        ArrayList<Cliente> clienti = GUI.getClienti();
        comboBox1 = new JComboBox();
        for(Cliente c : clienti) {
            comboBox1.addItem(c.getNome()+" età: "+c.getEtà());
        }
    }
}
