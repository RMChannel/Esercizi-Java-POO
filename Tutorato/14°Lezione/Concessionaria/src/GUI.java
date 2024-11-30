import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class GUI {
    private JButton addVeicolo;
    private JPanel MainMenu;
    private JButton registraUnClienteButton;
    private JButton creaUnNuovoOrdineButton;
    private JButton visualizzaTuttiIClientiButton;
    private JButton visualizzaTuttiGliOrdiniButton;
    private JButton visualizzaTuttiIVeicoliButton;
    private JButton cancellaUnElementoButton;
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
                new CreaOrdine(concessionaria.getVeicoli(),concessionaria.getClienti());
            }
        });
        cancellaUnElementoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CancellaElemento(concessionaria.getVeicoli(),concessionaria.getClienti(),concessionaria.getOrdini());
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

    public static boolean removeVeicolo(Veicolo v) {
        return concessionaria.removeVeicolo(v);
    }

    public static boolean removeCliente(Cliente cliente) {
        return concessionaria.removeCliente(cliente);
    }

    public static void removeOrdine(Ordine o) {
        concessionaria.removeOrdine(o);
    }

    public static void main(String[] args) {
        frame = new JFrame("Concessionaria");
        frame.setContentPane(new GUI().MainMenu);
        if(!loaded) {
            loadAll();
            loaded=true;
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try {
            saveAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadAll() {
        File file=new File("auto.dat");
        File file2=new File("clienti.dat");
        File file3=new File("ordini.dat");
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
        try { //Caricamento ordini
            if(file3.exists()) {
                ObjectInputStream ordines = new ObjectInputStream(new FileInputStream("ordini.dat"));
                while (true) {
                    try {
                        concessionaria.addOrdine((Ordine) ordines.readObject());
                    }catch(EOFException e) {break;}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveAll() throws IOException {
        File file=new File("auto.dat");
        File file2=new File("clienti.dat");
        File file3=new File("ordini.dat");
        ObjectOutputStream auto = null;
        ObjectOutputStream clienti = null;
        ObjectOutputStream ordini = null;
        if(file.exists()) file.delete();
        if(file2.exists()) file2.delete();
        if(file3.exists()) file3.delete();
        try {
            auto = new ObjectOutputStream(new FileOutputStream("auto.dat"));
            clienti = new ObjectOutputStream(new FileOutputStream("clienti.dat"));
            ordini = new ObjectOutputStream(new FileOutputStream("ordini.dat"));
        }
        catch (FileNotFoundException ignored){};
        ArrayList<Veicolo> cars=concessionaria.getVeicoli();
        ArrayList<Cliente> clients=concessionaria.getClienti();
        ArrayList<Ordine> ordines=concessionaria.getOrdini();
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
        for(Ordine o:ordines){
            assert o != null;
            ordini.writeObject(o);
            if(ordines.getLast().equals(o)) concessionaria.setIds(o.getId()+1);
        }
        ordini.close();
    }
}