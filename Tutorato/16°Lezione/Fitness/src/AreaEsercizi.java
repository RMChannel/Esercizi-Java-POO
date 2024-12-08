import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaEsercizi {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JButton visualizzaGliEserciziDisponibiliButton;
    private JButton aggiungiUnNuovoEsercizioButton;
    private static JFrame frame;

    public AreaEsercizi() {
        frame = new JFrame();
        frame.setTitle("Area esercizi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        visualizzaGliEserciziDisponibiliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new VisualizzaEsercizi();
            }
        });
        aggiungiUnNuovoEsercizioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaEsercizio();
            }
        });
    }
}
