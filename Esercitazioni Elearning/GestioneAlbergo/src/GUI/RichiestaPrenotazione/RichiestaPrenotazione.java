package GUI.RichiestaPrenotazione;

import GUI.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class RichiestaPrenotazione extends JFrame {
    private JPanel panel;
    private JButton tornaIndietroButton;
    private JTextField checkin;
    private JTextField checkout;
    private JComboBox comboBox;
    private JButton cercaStanzaButton;

    private void buildGUI() {
        setTitle("Richiesta Prenotazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUI();
            }
        });
        cercaStanzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkin.getText().isEmpty() || checkout.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Uno dei campi è vuoto, controlla e riprova", "Errore campi vuoti", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                GregorianCalendar checkinGC = new GregorianCalendar();
                GregorianCalendar checkoutGC = new GregorianCalendar();
                Date date;
                try {
                    date=formatter.parse(checkin.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data check-in non scritta correttamente","Errore check-in",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                checkinGC.setTime(date);
                if(checkinGC.compareTo(new GregorianCalendar())<0) {
                    JOptionPane.showMessageDialog(null, "La data del check-in è antecedente a quella attuale", "Errore check-in", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    date=formatter.parse(checkout.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data check-out non scritta correttamente","Errore check-out",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                checkoutGC.setTime(date);
                if(checkoutGC.compareTo(new GregorianCalendar())<0) {
                    JOptionPane.showMessageDialog(null, "La data del check-out è antecedente a quella attuale", "Errore check-out", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(checkoutGC.compareTo(checkinGC)<0) {
                    JOptionPane.showMessageDialog(null, "La data del check-out è antecedente a quella di check-in", "Errore check-out", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dispose();
                new MostraStanze(checkinGC,checkoutGC,comboBox.getSelectedIndex()+1);
            }
        });
    }

    public RichiestaPrenotazione() {
        buildGUI();
    }

    public RichiestaPrenotazione(GregorianCalendar checkin, GregorianCalendar checkout, int tipo) {
        LocalDate ld=checkin.toZonedDateTime().toLocalDate();
        this.checkin.setText(ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/"+ld.getYear());
        ld=checkout.toZonedDateTime().toLocalDate();
        this.checkout.setText(ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/"+ld.getYear());
        comboBox.setSelectedIndex(tipo-1);
        buildGUI();
    }
}
