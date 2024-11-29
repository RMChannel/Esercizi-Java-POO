import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreaCliente {
    private JPanel panel1;
    private JTextField Nome;
    private JTextField Cognome;
    private JTextField Indirizzo;
    private JButton tornaIndietroButton;
    private JButton creaClienteButton;
    private static JFrame frame;

    public CreaCliente() {
        frame = new JFrame();
        frame.setTitle("Crea cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
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
        creaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Nome.getText().isEmpty() || Cognome.getText().isEmpty() || Indirizzo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Uno dei parametri è vuoto, controlla e riprova");
                } else {
                    Cliente cliente = new Cliente(Nome.getText(), Cognome.getText(), Indirizzo.getText());
                    GUI.addCliente(cliente);
                    JOptionPane.showMessageDialog(frame, "Cliente creato correttamente");
                    frame.dispose();
                    GUI.main(null);
                }
            }
        });
    }
}