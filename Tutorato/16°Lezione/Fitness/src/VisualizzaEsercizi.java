import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualizzaEsercizi {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JTable table1;
    private static JFrame frame;

    public VisualizzaEsercizi() {
        frame = new JFrame();
        frame.setTitle("Visualizza Esercizi");
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaEsercizi();
            }
        });
    }

    private void createUIComponents() {
        String[] colonne={"Tipo","Nome","Durata","Ripetizioni","Difficoltà","Descrizione"};
        DefaultTableModel model = new DefaultTableModel(colonne,0);
        table1 = new JTable(model);
        ArrayList<Esercizio> esercizi = GUI.getEsercizi();
        for(Esercizio e : esercizi) {
            String tipo="";
            String difficoltà="";
            if(e.getClass()==Cardio.class) tipo="Cardio";
            else if(e.getClass()==Forza.class) tipo="Forza";
            else tipo="Streching";
            switch (e.getDifficoltà()) {
                case 1:
                    difficoltà="Facile";
                    break;
                case 2:
                    difficoltà="Medio";
                    break;
                case 3:
                    difficoltà="Difficile";
                    break;
            }
            String[] row={tipo,e.getNome(),String.valueOf(e.getDurata()),String.valueOf(e.getRipetizioni()),difficoltà,e.eseguiEsercizio()};
            model.addRow(row);
        }
    }
}
