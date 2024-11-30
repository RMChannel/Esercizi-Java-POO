import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ordini {
    private JPanel panel1;
    private JTable table1;
    private JButton back;
    private static JFrame frame;
    private DefaultTableModel tableModel;

    public Ordini() {
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI.main(null);
            }
        });
    }

    private void createUIComponents() {
        String[] colonne={"ID","DATA ORDINE","CLIENTE","VEICOLO"};
        tableModel = new DefaultTableModel(colonne,0);
        table1 = new JTable(tableModel);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void createData(ArrayList<Ordine> ordiniList) {
        for(Ordine o: ordiniList) {
            String[] row = {
                    String.valueOf(o.getId()),
                    o.getData().getTime().toString(),
                    o.getCliente().getNome()+" "+o.getCliente().getCognome(),
                    o.getVeicolo().getMarca()+" "+o.getVeicolo().getModello()
            };
            tableModel.addRow(row);
        }
    }

    public void Switch(ArrayList<Ordine> ordiniList) throws InterruptedException {
        createData(ordiniList);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Ordini");
        frame.setContentPane(panel1);
    }
}
