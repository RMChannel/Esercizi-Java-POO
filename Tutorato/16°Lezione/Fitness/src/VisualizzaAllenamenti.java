import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class VisualizzaAllenamenti extends JFrame {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JTable table1;
    private static JFrame frame;

    public VisualizzaAllenamenti() {
        frame = new JFrame();
        frame.setTitle("Visualizza Allenamenti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaAllenamenti();
            }
        });
    }

    private void createUIComponents() {
        ArrayList<Allenamento> allenamenti=GUI.getAllenamenti();
        int size=1;
        for(Allenamento allenamento:allenamenti) {
            if(size<allenamento.getEsercizi().size()) size=allenamento.getEsercizi().size();
        }
        String[] colonne = new String[size];
        for(int i=1;i<=size;i++) {
            colonne[i-1]="Esercizio n°"+i;
        }
        DefaultTableModel model = new DefaultTableModel(colonne,0);
        table1=new JTable(model);
        for(Allenamento allenamento:allenamenti) {
            String[] row = new String[size];
            ArrayList<Esercizio> esercizi=allenamento.getEsercizi();
            for(int i=0;i<size;i++) {
                row[i]=esercizi.get(i).getNome();
            }
            model.addRow(row);
        }
    }
}
