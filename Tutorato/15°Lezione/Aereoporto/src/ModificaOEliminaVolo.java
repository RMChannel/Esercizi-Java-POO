import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaOEliminaVolo {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JButton modificaUnVoloButton;
    private JButton eliminaUnVoloButton;
    private static JFrame frame;

    public ModificaOEliminaVolo() {
        frame = new JFrame();
        frame.setTitle("Modifica o elimina Volo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,150);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestioneVoli();
            }
        });
        modificaUnVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ScegliModificaVolo();
            }
        });
        eliminaUnVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new EliminaUnVolo();
            }
        });
    }
}
