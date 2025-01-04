import Animale.Cane;
import Animale.Pesce;
import Animale.Uccello;
import ElencoAnimali.ElencoAnimali;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends JFrame {
    private JPanel panel1;
    private JTextField numeroAnimali;
    private JButton generateButton;
    private JButton alimentaButton;
    private JTextArea textArea1;
    private static ElencoAnimali elencoAnimali;
    private static int nCani;
    private static int nUccelli;
    private static int  nPesci;
    private static int max;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Animali");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                max=0;
                if(numeroAnimali.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Non hai inserito un numero, controlla e riprova","Errore parametro vuoto",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    max = Integer.parseInt(numeroAnimali.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Il numero non è scritto correttamente, controlla e rirprova","Errore lettura numero",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(max<1) {
                    JOptionPane.showMessageDialog(null,"Il numero di animali da generare dev'essere maggiore di 1","Errore parametro non valido",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Random rand = new Random();
                nCani = rand.nextInt(max) + 1;
                nUccelli = rand.nextInt(max-nCani) + 1;
                nPesci = 100-(nCani+nUccelli);
                elencoAnimali=new ElencoAnimali();
                for(int i=0;i<nCani;i++) {
                    elencoAnimali.addAnimale(new Cane("caneN"+(i+1),rand.nextInt(46)+5));
                }
                for(int i=0;i<nUccelli;i++) {
                    elencoAnimali.addAnimale(new Uccello("uccelloN"+(i+1)));
                }
                for(int i=0;i<nPesci;i++) {
                    elencoAnimali.addAnimale(new Pesce("pesceN"+(i+1)));
                }
                textArea1.setText("Generati "+max+" animali\n"+nCani+" cani\n"+nUccelli+" uccelli\n"+nPesci+" pesci");
            }
        });
        alimentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Generati "+max+" animali\n"+nCani+" cani\n"+nUccelli+" uccelli\n"+nPesci+" pesci\nAnimali alimentati - "+elencoAnimali.alimenta()+" invocazioni vuoiMangiare() ");
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
