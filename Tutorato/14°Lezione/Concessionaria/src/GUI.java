import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class GUI {
    private JButton addVeicolo;
    private JPanel MainMenu;
    private JButton registraUnClienteButton;
    private JButton creaUnNuovoOrdineButton;
    private JButton visualizzaTuttiIClientiButton;
    private JButton visualizzaTuttiGliOrdiniButton;
    private JButton visualizzaTuttiIVeicoliButton;
    private JButton SALVAButton;
    private static JFrame frame;
    private static Concessionaria concessionaria=new Concessionaria();
    private static boolean loaded=false;

    public GUI() {
        addVeicolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaAuto();
            }
        });
        visualizzaTuttiGliOrdiniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new Ordini().Switch(concessionaria.getOrdini());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        visualizzaTuttiIVeicoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Veicoli().Switch(concessionaria.getVeicoli());
            }
        });
        visualizzaTuttiIClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Clienti().Switch(concessionaria.getClienti());
            }
        });
        registraUnClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaCliente();
            }
        });
        creaUnNuovoOrdineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CreaOrdine();
            }
        });
    }

    public static void addCliente(Cliente cliente) {
        concessionaria.addCliente(cliente);
    }

    public static void addOrdine(Cliente cliente, Veicolo car) {
        concessionaria.addOrdine(cliente, car);
    }

    public static void addVeicolo(Veicolo v) {
        concessionaria.addVeicolo(v);
    }

    public static void main(String[] args) {
        frame = new JFrame("Concessionaria");
        frame.setContentPane(new GUI().MainMenu);
        if(!loaded) {
            File file=new File("auto.dat");
            File file2=new File("clienti.dat");
            try { //Caricamento veicoli
                if(file.exists()) {
                    ObjectInputStream auto = new ObjectInputStream(new FileInputStream("auto.dat"));
                    while (true) {
                        try {
                            Object o = auto.readObject();
                            Veicolo v;
                            if(o instanceof AutoIbrida) {
                                v = (AutoIbrida) o;
                            }
                            else if(o instanceof AutoElettrica) {
                                v = (AutoElettrica) o;
                            }
                            else {
                                v = (Moto) o;
                            }
                            concessionaria.addVeicolo(v);
                        }
                        catch(EOFException e) {break;}
                    }
                }
                loaded=true;
            }
            catch (Exception e) {
                e.printStackTrace();
            };
            try { //Caricamento clienti
                if(file2.exists()) {
                    ObjectInputStream clients = new ObjectInputStream(new FileInputStream("clienti.dat"));
                    while (true) {
                        try {
                            concessionaria.addCliente((Cliente) clients.readObject());
                        }
                        catch(EOFException e) {break;}
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            frame.setDefaultCloseOperation(saveAll());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static int saveAll() throws IOException {
        File file=new File("auto.dat");
        File file2=new File("clienti.dat");
        ObjectOutputStream auto = null;
        ObjectOutputStream clienti = null;
        if(file.exists()) file.delete();
        if(file2.exists()) file2.delete();
        try {
            auto = new ObjectOutputStream(new FileOutputStream("auto.dat"));
            clienti = new ObjectOutputStream(new FileOutputStream("clienti.dat"));
        }
        catch (FileNotFoundException ignored){};
        ArrayList<Veicolo> cars=concessionaria.getVeicoli();
        ArrayList<Cliente> clients=concessionaria.getClienti();
        for(Veicolo v:cars){
            assert v != null;
            if(v instanceof AutoIbrida) {
                AutoIbrida car=(AutoIbrida) v;
                auto.writeObject(car);
            }
            else if(v instanceof AutoElettrica) {
                AutoElettrica car=(AutoElettrica) v;
                auto.writeObject(car);
            }
            else {
                Moto car=(Moto) v;
                auto.writeObject(car);
            }
        }
        auto.close();
        for(Cliente c:clients){
            assert c != null;
            clienti.writeObject(c);
        }
        clienti.close();
        return JFrame.EXIT_ON_CLOSE;
    }
}