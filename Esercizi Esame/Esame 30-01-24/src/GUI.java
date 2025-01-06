import TesseraSportiva.TesseraSportiva;
import Ticket.TicketSportivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel panel;
    private JTextArea textArea1;
    private JButton operazioneSuFileButton;

    public GUI(TesseraSportiva paris2024) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tessera Sportiva");
        setSize(600,300);
        setLocationRelativeTo(null);
        setContentPane(panel);
        ArrayList<TicketSportivo> tickets=paris2024.getTickets();
        textArea1.append("Ticket utilizzabili:\n");
        for(TicketSportivo ticket:tickets){
            if(ticket.isUsable()) textArea1.append(ticket +"\n");
        }
        textArea1.append("\nTicket NON utilizzabili:\n");
        for(TicketSportivo ticket:tickets){
            if(!ticket.isUsable()) textArea1.append(ticket +"\n");
        }
        setVisible(true);
        operazioneSuFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file=new File("savedata.dat");
                if(paris2024.isUsabile()) {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(paris2024);
                        oos.close();
                    } catch (IOException e2) {
                        JOptionPane.showMessageDialog(null, "Stesso discorso di prima, sparati","Sparati",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(null,"Visto che c'era almeno un biglietto utilizzabile, è stato tutto salvato su file");
                }
                else {
                    if(file.delete()) {
                        JOptionPane.showMessageDialog(null,"Visto che non c'era nessun biglietto utilizzabile, il file è stato cancellato");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Il file non esisteva già di suo, quindi non è stata necessaria la cancellazione");
                    }
                }
            }
        });
    }
}
