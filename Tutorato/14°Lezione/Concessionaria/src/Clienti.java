import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clienti {
    private JPanel panel1;
    private JButton tornaIndietroButton;
    private JTable table1;
    private static JFrame frame;
    private DefaultTableModel tableModel;

    public Clienti() {
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUI.main(null);
            }
        });
    }

    public void Switch(ArrayList<Cliente> clienti) {
        createData(clienti);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Clienti");
        frame.setContentPane(panel1);
    }

    private void createUIComponents() {
        String[] colonne = {"Nome","Cognome","Indirizzo"};
        tableModel = new DefaultTableModel(colonne,0);
        table1 = new JTable(tableModel);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void createData(ArrayList<Cliente> cc) {
        cc.sort(Cliente::compareTo);
        for(Cliente c : cc) {
            String[] row = {
                    c.getNome(),c.getCognome(),c.getIndirizzo()
            };
            tableModel.addRow(row);
        }
    }
}
