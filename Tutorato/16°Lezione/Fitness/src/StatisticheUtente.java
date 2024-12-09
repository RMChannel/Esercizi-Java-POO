import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticheUtente extends JFrame {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JLabel nome;
    private JLabel eta;
    private JLabel obbiettivo;
    private JLabel allenamento;
    private static JFrame frame;

    public StatisticheUtente(Cliente cliente) {
        frame = new JFrame();
        frame.setTitle("Statistiche Utente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        nome.setText("Nome: "+cliente.getNome());
        eta.setText("Età: "+ cliente.getEtà());
        obbiettivo.setText("Obbiettivo: "+cliente.getObbiettivo());
        if(cliente.getPa()==null) {
            allenamento.setText("Nessun piano di allenamento inserito");
        }
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaUtenti();
            }
        });
    }
}
