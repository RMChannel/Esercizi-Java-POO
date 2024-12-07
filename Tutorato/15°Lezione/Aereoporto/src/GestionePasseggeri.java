import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionePasseggeri {
    private JPanel gestionePasseggeri;
    private JButton tornaIndietroButton;
    private JPanel panel;
    private JButton aggiungiUnPasseggeroButton;
    private JButton visualizzaLaListaDeiButton;
    private JButton cercaUnPasseggeroPerButton;
    private static JFrame frame;

    public GestionePasseggeri() {
        frame = new JFrame();
        frame.setTitle("Gestione Passeggeri");
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(gestionePasseggeri);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        aggiungiUnPasseggeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AggiungiPasseggero();
            }
        });
        visualizzaLaListaDeiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VisualizzaPasseggeri();
            }
        });
        cercaUnPasseggeroPerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CercaPerCodice();
            }
        });
    }
}
