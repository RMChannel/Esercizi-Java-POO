import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Delete {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JButton cancellaButton;
    private JComboBox listOfElements;
    private JLabel select;
    private static JFrame frame;
    private static ArrayList<Veicolo> cars;
    private static ArrayList<Cliente> clients;
    private static ArrayList<Ordine> ordines;

    public Delete(int operation, ArrayList<Veicolo> veicoli, ArrayList<Cliente> clienti, ArrayList<Ordine> ordini) {
        frame = new JFrame();
        cars=veicoli;
        clients=clienti;
        ordines=ordini;
        loadEverything(operation);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setContentPane(panel1);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CancellaElemento(veicoli, clienti, ordini);
            }
        });
        cancellaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operation) {
                    case 1:
                        if(!GUI.removeVeicolo(cars.get(listOfElements.getSelectedIndex()))) {
                            JOptionPane.showMessageDialog(frame, "Veicolo presente in un ordine, rimuovere prima l'ordine, poi cancellare il veicolo","Errore rimozione veicolo",JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Veicolo rimosso con successo","Rimozione veicolo effettuata",JOptionPane.INFORMATION_MESSAGE);
                            frame.dispose();
                            GUI.main(null);
                        }
                        break;
                    case 2:
                        if(!GUI.removeCliente(clients.get(listOfElements.getSelectedIndex()))) {
                            JOptionPane.showMessageDialog(frame,"Cliente presente in un ordine, rimuovere prima l'ordine, poi cancellare il cliente","Errore rimozione cliente",JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Cliente rimosso con successo","Rimozione cliente effettuata",JOptionPane.INFORMATION_MESSAGE);
                            frame.dispose();
                            GUI.main(null);
                        }
                        break;
                    case 3:
                        GUI.removeOrdine(ordines.get(listOfElements.getSelectedIndex()));
                        JOptionPane.showMessageDialog(frame, "Rimozione Ordine effettuata","Conferma rimozione ordine",JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        GUI.main(null);
                        break;
                }
            }
        });
    }

    public void loadEverything(int operation) {
        switch (operation) {
            case 1:
                frame.setTitle("Cancella Veicolo");
                select.setText("Selecione un Veicolo");
                for(Veicolo v : cars) {
                    listOfElements.addItem(v.getMarca()+" "+v.getModello());
                }
                break;
            case 2:
                frame.setTitle("Cancella Cliente");
                select.setText("Selecione un Cliente");
                for(Cliente c : clients) {
                    listOfElements.addItem(c.getNome()+" "+c.getCognome());
                }
                break;
            case 3:
                frame.setTitle("Cancella Ordine");
                select.setText("Selecione un Ordine");
                for(Ordine o : ordines) {
                    listOfElements.addItem(o.getCliente().getNome()+" "+o.getCliente().getCognome()+" "+o.getVeicolo().getMarca()+" "+o.getVeicolo().getModello());
                }
                break;
        }
    }
}
