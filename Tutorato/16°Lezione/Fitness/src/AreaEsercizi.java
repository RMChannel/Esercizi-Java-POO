import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaEsercizi extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JButton visualizzaGliEserciziDisponibiliButton;
    private JButton aggiungiUnNuovoEsercizioButton;

    public AreaEsercizi() {
        setTitle("Area esercizi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUI();
            }
        });
        visualizzaGliEserciziDisponibiliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisualizzaEsercizi();
            }
        });
        aggiungiUnNuovoEsercizioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreaEsercizio();
            }
        });
    }
}
