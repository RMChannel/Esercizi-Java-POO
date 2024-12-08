import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GUI {
    private JPanel panel;
    private JButton areaEserciziButton;
    private JButton areaUtentiButton;
    private JButton areaAllenamentiButton;
    private static JFrame frame;
    private static ArrayList<Esercizio> esercizi;
    private static ArrayList<Cliente> clienti;
    private static ArrayList<Allenamento> allenamenti;

    public GUI() {
        frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Gestore Fitness");
        frame.setVisible(true);
        areaEserciziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaEsercizi();
            }
        });
        areaUtentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaUtenti();
            }
        });
        areaAllenamentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AreaAllenamenti();
            }
        });
    }

    public static void main(String[] args) {
        esercizi = new ArrayList<>();
        clienti = new ArrayList<>();
        allenamenti=new ArrayList<>();
        ArrayList<Esercizio> temp;
        Cardio cTemp=new Cardio();
        Forza fTemp=new Forza();
        Streching stTemp=new Streching();
        temp=cTemp.pianificaAllenamento();
        esercizi.addAll(temp);
        allenamenti.add(new Allenamento(temp));
        temp=fTemp.pianificaAllenamento();
        esercizi.addAll(temp);
        allenamenti.add(new Allenamento(temp));
        temp=stTemp.pianificaAllenamento();
        esercizi.addAll(temp);
        allenamenti.add(new Allenamento(temp));
        Collections.shuffle(esercizi);
        Cliente c1=new Cliente("Roberto",20,"Perdere peso");
        Cliente c2=new Cliente("Antonia",20,"Perdere peso");
        Cliente c3=new Cliente("Leqso",20,"Prendere massa e diventare grosso");
        clienti.add(c1);
        clienti.add(c2);
        clienti.add(c3);
        new GUI();
    }

    public static ArrayList<Esercizio> getEsercizi() {
        return esercizi;
    }

    public static void aggiungiEsercizio (Esercizio e) {
        esercizi.add(e);
    }

    public static ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public static ArrayList<Allenamento> getAllenamenti() {
        return allenamenti;
    }

    public static void addAllenamento(Allenamento e) {
        allenamenti.add(e);
    }
}
