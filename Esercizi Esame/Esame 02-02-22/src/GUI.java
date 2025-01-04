import AutoMezzo.Auto;
import AutoMezzo.AutoMezzo;
import AutoMezzo.Furgone;
import AutoMezzo.Moto;
import Hertz.Hertz;
import Hertz.PrestitoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class GUI extends JFrame {
    private JPanel panel;
    private JTextField numeroAutoMezzi;
    private JButton generaButton;
    private JTextArea textArea1;
    private JButton simulaButton;
    private static Hertz hertz;
    private static int numeroAuto;
    private static int numeroFurgone;
    private static int numeroMoto;
    private static int max;
    private static final char[] alfabeto={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','U','V','W','X','Y','Z'};
    private static final String[] marcheFurgone = {"Ford","Citroen","Fiat"};
    private static final Random random = new Random();

    public GUI() {
        setTitle("Hertz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
        generaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numeroAutoMezzi.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Parametro non inserito","Errore parametro vuoto",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    max = Integer.parseInt(numeroAutoMezzi.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Il parametro inserito non è corretto, controlla e riprova","Errore parametro",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(max<1) {
                    JOptionPane.showMessageDialog(null,"Il parametro dev'essere maggiore o uguale ad 1","Errore parametro minore di 1",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                hertz = new Hertz();
                numeroAuto = random.nextInt(max)+1;
                numeroFurgone = random.nextInt(max-numeroAuto)+1;
                numeroMoto = max-(numeroAuto+numeroFurgone);
                for(int i=0;i<numeroAuto;i++) {
                    hertz.addAutoMezzo(new Auto("auto"+(i+1),"modello"+(i+1),random.nextInt(770)+30,generaTarga()));
                }
                for(int i=0;i<numeroFurgone;i++) {
                    hertz.addAutoMezzo(new Furgone(marcheFurgone[random.nextInt(marcheFurgone.length)], "modello"+(i+1),random.nextInt(770)+30,generaTarga()));
                }
                for(int i=0;i<numeroMoto;i++) {
                    hertz.addAutoMezzo(new Moto("moto"+(i+1),"modello"+(i+1),random.nextInt(770)+30,generaTarga()));
                }
                textArea1.setText("Generati "+max+" automezzi\n"+numeroAuto+" Auto\n"+numeroFurgone+" Furgone\n"+numeroMoto+" Moto");
            }
        });
        simulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice;
                double totale=0;
                for(int i=0, j=0;i<100 || j<100;) {
                        choice = random.nextInt(2);
                    if(choice == 1 && i<100) {
                        ArrayList<AutoMezzo> veicoliInPrestito=hertz.dammiAutomezziInPrestito();
                        if(veicoliInPrestito.isEmpty()) {
                            System.err.println("Non c'è nessun automezzo in prestito al momento");
                            continue;
                        }
                        AutoMezzo autoMezzo=veicoliInPrestito.get(random.nextInt(veicoliInPrestito.size()));
                        GregorianCalendar dataFine = (GregorianCalendar) autoMezzo.getDataInizioNoleggio().clone();
                        dataFine.add(Calendar.DAY_OF_MONTH,3);
                        try {
                            totale+=hertz.effettuaReso(autoMezzo.getTarga(),dataFine);
                        } catch (PrestitoException e1) {
                            System.out.println("Ciò dovrebbe essere impossibile, se accade, java sparati in bocca, grazie");
                        }
                        i++;
                    }
                    else if(j<100) {
                        ArrayList<AutoMezzo> veicoliNonInPrestito=hertz.dammiAutomezziNonInPrestito();
                        if(veicoliNonInPrestito.isEmpty()) {
                            System.err.println("Non ci sono veicoli disponibili al momento");
                            continue;
                        }
                        AutoMezzo autoMezzo=veicoliNonInPrestito.get(random.nextInt(veicoliNonInPrestito.size()));
                        hertz.effettuaPrestito(autoMezzo.getTarga());
                        j++;
                    }
                }
                textArea1.setText("Generati "+max+" automezzi\n"+numeroAuto+" Auto\n"+numeroFurgone+" Furgone\n"+numeroMoto+" Moto"+"\nEffettutati 100 prestiti e 100 resi per un guadagno di "+totale+"€");
            }
        });
    }

    public String generaTarga() {
        String targa="";
        targa+=alfabeto[random.nextInt(alfabeto.length)];
        targa+=alfabeto[random.nextInt(alfabeto.length)];
        targa+=random.nextInt(10);
        targa+=random.nextInt(10);
        targa+=random.nextInt(10);
        targa+=alfabeto[random.nextInt(alfabeto.length)];
        targa+=alfabeto[random.nextInt(alfabeto.length)];
        return targa;
    }

    public static void main(String[] args) {
        new GUI();
    }
}
