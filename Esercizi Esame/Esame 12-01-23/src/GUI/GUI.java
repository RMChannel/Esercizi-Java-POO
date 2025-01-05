package GUI;

import AutoVettura.AutoVettura;
import AutoVettura.Benzina;
import AutoVettura.Elettriche;
import AutoVettura.Ibride;
import GranPrix.GranPrix;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GUI extends JFrame {
    private JPanel panel1;
    private JTextField numeroAutovetture;
    private JButton simulaButton;
    private JTextArea textArea1;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GranPrix");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);
        simulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numeroAutovetture.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Non hai inserito un numero di vetture, controlla e riprova","Errore parametro vuoto",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int nVetture = 0;
                try {
                    nVetture = Integer.parseInt(numeroAutovetture.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Il numero non è scritto correttamente, controlla e riprova","Errore parametro incorretto",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Random rand = new Random();
                int nBenzina = rand.nextInt(nVetture)+1;
                int nIbride = rand.nextInt(nVetture-nBenzina)+1;
                int nElettriche = nVetture-(nBenzina+nIbride);
                GranPrix granPrix = new GranPrix(7,30,8,5);
                for (int i=0; i<nBenzina || i<nIbride || i<nElettriche; i++) {
                    if(i<nBenzina) granPrix.AddVetture(new Benzina("benzina"+(i+1),rand.nextInt(751)+50));
                    if(i<nIbride) granPrix.AddVetture(new Ibride("ibrida"+(i+1),rand.nextInt(751)+50));
                    if(i<nElettriche) granPrix.AddVetture(new Elettriche("elettrica"+(i+1),rand.nextInt(751)+50));
                }
                granPrix.avviaMotori();
                for(int i=0; i< granPrix.getNumeroGiri(); i++) {
                    granPrix.effettuaGiro();
                    granPrix.pitStop(rand.nextInt(nVetture));
                }
                ArrayList<AutoVettura> vetture = granPrix.getVetture();
                vetture.sort(new Comparator<AutoVettura>() {
                    public int compare(AutoVettura a1, AutoVettura a2) {
                        return Double.compare(a1.getTempoImpiegato(), a2.getTempoImpiegato());
                    }
                });
                textArea1.setText("Create "+nVetture+" autovetture\nEffettuati "+granPrix.getNumeroGiri()+" giri\n********\nOrdine di arrivo\n1° Posto\n"+vetture.getFirst().getNome()+"\n2° Posto\n"+vetture.get(1).getNome()+"\n3° Posto\n"+vetture.get(2).getNome()+"\n********");
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
