import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ModificaVolo {
    private JButton tornaIndietroButton;
    private JPanel panel1;
    private JTextField codiceText;
    private JTextField destinazioneText;
    private JButton modificaVoloButton;
    private JTextField orarioDiPartenzaText;
    private JTextField orarioDiArrivoText;
    private static JFrame frame;
    private static Volo volo;

    public ModificaVolo(Volo v) {
        volo = v;
        frame = new JFrame();
        frame.setTitle("Modifica Volo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tornaIndietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ModificaOEliminaVolo();
            }
        });
        modificaVoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                volo.setCodice(codiceText.getText());
                volo.setDestinazione(destinazioneText.getText());
                try {
                    GregorianCalendar gc = new GregorianCalendar();
                    GregorianCalendar gc2 = new GregorianCalendar();
                    gc.setTime(sdf.parse(orarioDiPartenzaText.getText()));
                    volo.setOrarioDiPartenza(gc);
                    gc2.setTime(sdf.parse(orarioDiArrivoText.getText()));
                    volo.setOrarioDiArrivo(gc2);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "Volo modificato con successo");
                frame.dispose();
                new GUI();
            }
        });
    }

    private void createUIComponents() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        codiceText = new JTextField(volo.getCodice());
        destinazioneText = new JTextField(volo.getDestinazione());
        orarioDiPartenzaText = new JTextField(sdf.format(volo.getOrarioDiPartenza().getTime()));
        orarioDiArrivoText = new JTextField(sdf.format(volo.getOrarioDiArrivo().getTime()));
    }
}
