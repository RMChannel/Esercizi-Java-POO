import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CreaAuto {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JComboBox comboBox1;
    private JPanel elettrica;
    private JPanel ibrida;
    private JPanel moto;
    private JButton aggiungiVeicoloButton;
    private JTextField marca;
    private JTextField modello;
    private JTextField anno;
    private JTextField prezzo;
    private JTextField option1;
    private JTextField option2;
    private JLabel option1text;
    private JLabel option2text;
    private static JFrame frame;

    public CreaAuto() {
        frame = new JFrame();
        frame.setTitle("Crea auto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setContentPane(panel1);
        caricaMenu();
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI.main(null);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caricaMenu();
            }
        });
        aggiungiVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(marca.getText().isEmpty() || modello.getText().isEmpty() || anno.getText().isEmpty() || prezzo.getText().isEmpty() || option1.getText().isEmpty() || option2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Uno dei parametri è vuoto, controlla e riprova","Errore parametri", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Veicolo auto = null;
                    switch (Objects.requireNonNull(comboBox1.getSelectedItem()).toString()) {
                        case "Auto Elettrica":
                            auto = new AutoElettrica(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(anno.getText()),Integer.parseInt(option1.getText()),Integer.parseInt(option2.getText()));
                            break;
                        case "Auto Ibrida":
                            auto = new AutoIbrida(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(anno.getText()),Double.parseDouble(option1.getText()),option2.getText());
                            break;
                        case "Moto":
                            auto = new AutoIbrida(marca.getText(),modello.getText(),Double.parseDouble(prezzo.getText()),Integer.parseInt(anno.getText()),Integer.parseInt(option1.getText()),option2.getText());
                            break;
                    }
                    GUI.addVeicolo(auto);
                    JOptionPane.showMessageDialog(frame, "Auto aggiunta correttamente");
                    frame.dispose();
                    GUI.main(null);
                }
            }
        });
    }

    private void caricaMenu() {
        switch (Objects.requireNonNull(comboBox1.getSelectedItem()).toString()) {
            case "Auto Elettrica":
                option1text.setText("Capacità batteria: ");
                option2text.setText("Autonomia batteria: ");
                break;
            case "Auto Ibrida":
                option1text.setText("Consumo medio: ");
                option2text.setText("Tipo motore: ");
                break;
            case "Moto":
                option1text.setText("Cilindrata: ");
                option2text.setText("Tipo moto: ");
                break;
        }
    }
}
