import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GUI extends JFrame {
    private JPanel home;
    private JButton gestisciIVoliButton;
    private JButton gestisciIPasseggeriButton;
    private JButton gestisciICheckInButton;
    private JFrame frame;
    private static Aereoporto aereoporto;

    public GUI() {
        frame = new JFrame();
        frame.setContentPane(home);
        frame.setTitle("Aereoporto");
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gestisciIVoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestioneVoli();
            }
        });
        gestisciIPasseggeriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GestionePasseggeri();
            }
        });
        gestisciICheckInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CheckIn();
            }
        });
    }

    public static void main(String[] args) {
        aereoporto = new Aereoporto();
        Aereo aereo1 = new Aereo(1,300,2015);
        Aereo aereo2 = new Aereo(2,500,2012);
        Aereo aereo3 = new Aereo(3,200,2017);
        Passeggero passeggero1=new Passeggero("Roberto","Cito",new GregorianCalendar(2004,4,25),1,4523);
        Passeggero passeggero2=new Passeggero("Arjel","Buzi",new GregorianCalendar(2004, 1,26),2,4565);
        Passeggero passeggero3=new Passeggero("Antonia","Grieco",new GregorianCalendar(2004,4,4),3,6753);
        aereoporto.aggiungiAereo(aereo1);
        aereoporto.aggiungiAereo(aereo2);
        aereoporto.aggiungiAereo(aereo3);
        aereoporto.aggiungiPersona(passeggero1);
        aereoporto.aggiungiPersona(passeggero2);
        aereoporto.aggiungiPersona(passeggero3);
        aereoporto.newVolo("AFV244CW",aereo1,"Ibiza",new GregorianCalendar(2024,12,7,15,0),new GregorianCalendar(2024,12,8,2,0),true);
        new GUI();
    }

    public static void aggiungiPasseggero(Passeggero passeggero) {
        aereoporto.aggiungiPersona(passeggero);
    }

    public static ArrayList<Persona> getPersone() {
        return aereoporto.getPersone();
    }

    public static ArrayList<Volo> getVoli() {
        return aereoporto.getVoli();
    }

    public static ArrayList<Aereo> getAerei() {
        return aereoporto.getAerei();
    }

    public static void aggiungiVolo(String codice, Aereo aereo, String destinazione, GregorianCalendar orarioDiPartenza, GregorianCalendar orarioDiArrivo, boolean PA) {
        aereoporto.newVolo(codice,aereo,destinazione,orarioDiPartenza,orarioDiArrivo,PA);
    }

    public static void checkIn(Passeggero passeggero,Volo volo) {
        aereoporto.checkIn(passeggero,volo);
    }
}
