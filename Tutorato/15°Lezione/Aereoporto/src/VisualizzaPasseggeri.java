import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualizzaPasseggeri {
    private JPanel panel;
    private JButton chiudiButton;
    private JTable table1;
    private static JFrame frame;


    public VisualizzaPasseggeri() {
        frame = new JFrame();
        frame.setTitle("Tabella Passeggeri");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        chiudiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    private void createUIComponents() {
        String[] colonne={"Tipo","Nome","Cognome","Data di nascita","ID"};
        DefaultTableModel model = new DefaultTableModel(colonne,0);
        ArrayList<Persona> persone=GUI.aereoporto.getPersone();
        table1 = new JTable(model);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for(Persona p:persone) {
            String[] row={p.getClass().toString(),p.getNome(),p.getCognome(),p.getDataNascita().getTime().toString(),String.valueOf(p.getId())};
            model.addRow(row);
        }
    }
}
