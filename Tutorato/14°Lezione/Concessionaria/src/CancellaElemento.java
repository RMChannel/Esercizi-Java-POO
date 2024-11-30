import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancellaElemento {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JButton cancellaUnVeicoloButton;
    private JButton cancellaUnClienteButton;
    private JButton cancellaUnOrdineButton;
    private JFrame frame;
    private ArrayList<Ordine> o;
    private ArrayList<Cliente> c;
    private ArrayList<Veicolo> v;

    public CancellaElemento(ArrayList<Veicolo> veicoli, ArrayList<Cliente> clienti, ArrayList<Ordine> ordini) {
        frame = new JFrame();
        v=veicoli;
        c=clienti;
        o=ordini;
        frame.setTitle("Cancella Elemento");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        cancellaUnVeicoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chiamaDelete(1);
            }
        });
        cancellaUnClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chiamaDelete(2);
            }
        });
        cancellaUnOrdineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chiamaDelete(3);
            }
        });
    }

    public void chiamaDelete(int n) {
        frame.dispose();
        new Delete(n,v,c,o);
    }
}
