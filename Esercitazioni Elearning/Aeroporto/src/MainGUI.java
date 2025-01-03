import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainGUI extends JFrame {
    private JPanel panel1;
    private JTextField partenza;
    private JTextField arrivo;
    private JButton cercaButton;
    private JComboBox comboBox1;
    private JButton selezionaButton;
    public static FlightList flightList;

    public MainGUI() {
        setTitle("Aeroporto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightList flSearched=flightList.search(partenza.getText(), arrivo.getText());
                comboBox1.removeAllItems();
                for(Volo v:flSearched.getVoli()) {
                    comboBox1.addItem(v.getCodice());
                }
            }
        });
        selezionaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(MainGUI.this, "Non c'è nessun volo disponibile per quello che hai cercato", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    dispose();
                    new PostoGUI((String) comboBox1.getSelectedItem());
                }
            }
        });
    }

    public static void main(String[] args) {
        Volo volo1 = new Volo("Torino Caselle", "Roma Fiumicino", "AZ101", "Alitalia", new int[]{1, 2, 3});
        Volo volo2 = new Volo("Venezia Marco Polo", "Parigi Charles de Gaulle", "AF202", "Air France", new int[]{1, 2, 3});
        Volo volo3 = new Volo("Milano Malpensa", "Madrid Barajas", "IB303", "Iberia", new int[]{1, 2, 3});
        Volo volo4 = new Volo("Napoli Capodichino", "Barcellona El Prat", "VY404", "Vueling", new int[]{1, 2, 3});
        Volo volo5 = new Volo("Bologna Guglielmo Marconi", "Londra Heathrow", "BA505", "British Airways", new int[]{1, 2, 3});
        Volo volo6 = new Volo("Firenze Peretola", "Amsterdam Schiphol", "KL606", "KLM", new int[]{1, 2, 3});
        Volo volo7 = new Volo("Catania Fontanarossa", "Monaco di Baviera", "LH707", "Lufthansa", new int[]{1, 2, 3});
        Volo volo8 = new Volo("Palermo Punta Raisi", "Zurigo", "LX808", "Swiss", new int[]{1, 2, 3});
        Volo volo9 = new Volo("Genova Cristoforo Colombo", "Francoforte", "LH909", "Lufthansa", new int[]{1, 2, 3});
        Volo volo10 = new Volo("Cagliari Elmas", "Bruxelles", "SN010", "Brussels Airlines", new int[]{1, 2, 3});
        flightList = new FlightList();
        try {
            flightList.addFlight(volo1);
            flightList.addFlight(volo2);
            flightList.addFlight(volo3);
            flightList.addFlight(volo4);
            flightList.addFlight(volo5);
            flightList.addFlight(volo6);
            flightList.addFlight(volo7);
            flightList.addFlight(volo8);
            flightList.addFlight(volo9);
            flightList.addFlight(volo10);
        } catch(BadCodeException e) {
            System.out.println("C'è un clone, porco dio");
        }
        new MainGUI();
    }
}
