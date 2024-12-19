package it.unisa.compagniaaerea;

import it.unisa.compagniaaerea.compagnia.CompagniaAerea;
import it.unisa.compagniaaerea.compagnia.OverbookingException;
import it.unisa.compagniaaerea.passeggero.InserimentoPasseggeroException;
import it.unisa.compagniaaerea.passeggero.PasseggeroBusiness;
import it.unisa.compagniaaerea.passeggero.PasseggeroEconomica;
import it.unisa.compagniaaerea.volo.InserimentoVoloException;
import it.unisa.compagniaaerea.volo.Volo;
import it.unisa.compagniaaerea.volo.VoloInternazionale;
import it.unisa.compagniaaerea.volo.VoloNazionale;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Random;

public class GUI extends JFrame {
    private JPanel panel1;
    private JLabel nomeCompagnia;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextArea textArea1;
    private static CompagniaAerea compagniaAerea;
    public GUI() {
        setTitle("Compagnia Aerea");
        textField1.setText(String.valueOf(compagniaAerea.getGuadagno()));
        textField2.setText(String.valueOf(compagniaAerea.getNumeroPasseggeri()));
        for(Volo v: compagniaAerea.getVoli()) {
            comboBox1.addItem(v.getCodiceVolo());
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        nomeCompagnia.setText(compagniaAerea.getNome());
        setVisible(true);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComboBox();
            }
        });
        updateComboBox();
    }

    public void updateComboBox() {
        Volo volo=null;
        for(Volo v: compagniaAerea.getVoli()) {
            if(v.getCodiceVolo().equals(comboBox1.getSelectedItem().toString())) {
                volo=v;
            }
        }
        LocalDate lc =volo.getData().toZonedDateTime().toLocalDate();
        textArea1.setText("durata "+volo.getOre()+" ore\ndata: "+lc.getDayOfMonth()+"/"+lc.getMonth().getValue()+"/"+lc.getYear()+"\npostiDisponibiliEconomy: "+volo.getPostiDisponibiliEconomy()+"\npostiDisponibiliBusiness: "+volo.getPostiDisponibiliBusiness());
    }

    public static void main(String[] args) throws InserimentoVoloException, InserimentoPasseggeroException, OverbookingException {
        Random rand = new Random();
        compagniaAerea = new CompagniaAerea("ITA AIRWAYS");
        compagniaAerea.aggiungiVolo(new VoloNazionale("GC134FC",20,new GregorianCalendar(2025,3,25),7,8,1000));
        compagniaAerea.aggiungiVolo(new VoloNazionale("DK245XA",10,new GregorianCalendar(2025,5,25),7,8,500));
        compagniaAerea.aggiungiVolo(new VoloInternazionale("SQ245CD",15,new GregorianCalendar(2025,2,21),10,10,750));
        compagniaAerea.aggiungiVolo(new VoloInternazionale("SQ235GD",15,new GregorianCalendar(2025,1,31),10,10,300));
        for(int i=0;i<25;i++) {
            compagniaAerea.aggiungiPasseggero(new PasseggeroEconomica(String.valueOf(i),String.valueOf(i),rand.nextInt(2024-1990+1)+1990));
        }
        for(int i=0;i<25;i++) {
            compagniaAerea.aggiungiPasseggero(new PasseggeroBusiness(String.valueOf(i+25),String.valueOf(i+25),rand.nextInt(2024-1990+1)+1990));
        }
        for(int i=0;i<70;i++) {
            String classe;
            if(rand.nextInt(2)==0) {
                classe="economy";
            }
            else classe="business";
            try {
                compagniaAerea.prenotaVolo(compagniaAerea.getVoli().get(rand.nextInt(compagniaAerea.getVoli().size())).getCodiceVolo(),compagniaAerea.getPasseggeri().get(rand.nextInt(compagniaAerea.getPasseggeri().size())),classe);
            } catch (OverbookingException e) {
                System.out.println("OverBooking accaduto");
            }
        }
        GUI gui = new GUI();
    }
}
