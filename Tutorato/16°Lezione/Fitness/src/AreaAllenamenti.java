import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaAllenamenti {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JButton creaUnNuovoAllenamentoButton;
    private JButton visualizzaAllenamentiButton;
    private static JFrame frame;

    public AreaAllenamenti() {
        frame = new JFrame("Area Allenamenti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
        creaUnNuovoAllenamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaAllenamento();
            }
        });
        visualizzaAllenamentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new VisualizzaAllenamenti();
            }
        });
    }
}
