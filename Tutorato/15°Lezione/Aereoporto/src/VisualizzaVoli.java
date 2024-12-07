import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualizzaVoli {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JTable tabella;
    private static JFrame frame;

    public VisualizzaVoli() {
        frame = new JFrame();
        frame.setTitle("Tabella voli");
        frame.setSize(1600,600);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestioneVoli();
            }
        });
    }

    private void createUIComponents() {
        String[] colonne={"Codice","Aereo","Destinazione","Orario di partenza","Orario di arrivo","Numeri di passeggeri","Numero di membri dello staff"};
        ArrayList<Volo> voli=GUI.getVoli();
        DefaultTableModel model = new DefaultTableModel(colonne,0);
        tabella = new JTable(model);
        for(Volo v:voli) {
            String[] row={v.getCodice(),v.getAereo().toString(),v.getDestinazione(),v.getOrarioDiPartenza().getTime().toString(),v.getOrarioDiArrivo().getTime().toString(),String.valueOf(v.getNPasseggeri()),String.valueOf(v.getNStaff())};
            model.addRow(row);
        }
    }
}
