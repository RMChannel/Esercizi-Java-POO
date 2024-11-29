import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Veicoli {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JTable table1;
    private static JFrame frame;
    private DefaultTableModel tableModel;

    public Veicoli() {
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI.main(null);
            }
        });
    }

    public void Switch(ArrayList<Veicolo> cars) {
        createData(cars);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Veicoli");
        frame.setContentPane(panel1);
    }

    private void createUIComponents() {
        String[] colonne={"MARCA","MODELLO","ANNO DI I.","PREZZO"};
        tableModel = new DefaultTableModel(colonne,0);
        table1 = new JTable(tableModel);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void createData(ArrayList<Veicolo> cars) {
        for(Veicolo car : cars) {
            String[] row = {
              car.getMarca(),
              car.getModello(),
              String.valueOf(car.getAnno()),
              String.valueOf(car.getPrezzo())
            };
            tableModel.addRow(row);
        }
    }
}
