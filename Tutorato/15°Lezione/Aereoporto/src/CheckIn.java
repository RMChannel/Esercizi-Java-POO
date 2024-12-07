import javax.swing.*; //TODO
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUI();
            }
        });
    }
}
