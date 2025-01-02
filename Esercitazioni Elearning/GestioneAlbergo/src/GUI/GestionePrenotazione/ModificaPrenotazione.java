package GUI.GestionePrenotazione;

import GUI.GUI;
import Hotel.Prenotazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class ModificaPrenotazione extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JTextField dataCheckOut;
    private JButton modificaButton;

    public ModificaPrenotazione(Prenotazione prenotazione) {
        LocalDate ld=prenotazione.getCheckout().toZonedDateTime().toLocalDate();
        dataCheckOut.setText(ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/"+ld.getYear());
        setTitle("Modifica Prenotazione"+prenotazione.getCliente().getNome()+" "+prenotazione.getCliente().getCognome()+" "+prenotazione.getStanza().getNumero());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OpzioniPrenotazione(prenotazione);
            }
        });
        modificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date;
                try {
                    date=formatter.parse(dataCheckOut.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data non scritta correttamente", "Errore data", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(date);
                prenotazione.setCheckout(gc);
                dispose();
                JOptionPane.showMessageDialog(null, "Data Check-Out modificata correttamente");
                new GUI();
            }
        });
    }
}
