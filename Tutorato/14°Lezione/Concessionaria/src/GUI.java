import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton addVeicolo;
    private JPanel MainMenu;
    private JButton registraUnClienteButton;
    private JButton creaUnNuovoOrdineButton;
    private JButton visualizzaTuttiIClientiButton;
    private JButton visualizzaTuttiGliOrdiniButton;
    private JButton visualizzaTuttiIVeicoliButton;
    private static JFrame frame;
    private static Concessionaria concessionaria=new Concessionaria();

    public GUI() {
        addVeicolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        });
        visualizzaTuttiGliOrdiniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new Ordini().Switch(concessionaria.getOrdini());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        visualizzaTuttiIVeicoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Veicoli().Switch(concessionaria.getVeicoli());
            }
        });
        visualizzaTuttiIClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Clienti().Switch(concessionaria.getClienti());
            }
        });
        registraUnClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaCliente();
            }
        });
    }

    public static void addCliente(Cliente cliente) {
        concessionaria.addCliente(cliente);
    }

    public static void addOrdine(Cliente cliente, Veicolo car) {
        concessionaria.addOrdine(cliente, car);
    }

    public static void addVeicolo(Veicolo v) {
        concessionaria.addVeicolo(v);
    }

    public static void main(String[] args) {
        frame = new JFrame("Concessionaria");
        frame.setContentPane(new GUI().MainMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
