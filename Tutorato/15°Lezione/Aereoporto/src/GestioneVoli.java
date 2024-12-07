import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneVoli {
    private JPanel gestioneVoli;
    private JButton tornaIndietroButton;
    private JPanel panel;
    private JButton aggiungiUnNuovoVoloButton;
    private JButton visualizzaLElencoDeiButton;
    private JButton modificaORimuoviUnButton;
    private static JFrame frame;

    public GestioneVoli() {
        frame = new JFrame();
        frame.setContentPane(gestioneVoli);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Gestione voli");
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        aggiungiUnNuovoVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AggiungiVolo();
            }
        });
        visualizzaLElencoDeiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new VisualizzaVoli();
            }
        });
        modificaORimuoviUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
