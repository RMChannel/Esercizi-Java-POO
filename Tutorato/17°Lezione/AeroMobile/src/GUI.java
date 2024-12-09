import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class GUI extends JFrame {
    private JPanel panel;
    private JComboBox comboBox;
    private JTextArea textArea;
    private JTextField textField1;
    private JButton cercaCodiceButton;
    private static ArrayList<Aeromobile> aeromobiles;

    public GUI() {
        setTitle("Gestore aeromobili");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,300);
        setLocationRelativeTo(null);
        updateTextArea();
        setContentPane(panel);
        setVisible(true);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTextArea();
            }
        });
        cercaCodiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Aeromobile a : aeromobiles) {
                    if(a.getClass().equals(Aeroplano.class)) {
                        if(Objects.equals(((Aeroplano) a).getCodiceVolo(), textField1.getText())) {
                            textArea.setText(a.toString());
                            return;
                        }
                    }
                }
                throw new IllegalArgumentException("Codice volo non trovato");
            }
        });
    }

    public static void main(String[] args) throws IOException {
        aeromobiles = new ArrayList<>();
        File file=new File("save.dat");
        if(file.exists()){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                try {
                    Object obj = in.readObject();
                    if(obj instanceof Aeromobile){
                        aeromobiles.add((Aeromobile)obj);
                    }
                } catch (ClassNotFoundException e) {
                    throw new IOException("Errore nella lettura del file");
                } catch (EOFException e) {
                    break;
                }
            }
        }
        new GUI();
    }

    public void updateTextArea() {
        StringBuilder textAreaString= new StringBuilder();
        switch (comboBox.getSelectedIndex()) {
            case 0:
                for(Aeromobile aeromobile:aeromobiles){
                    if(aeromobile.getClass().equals(Aeroplano.class)){
                        Aeroplano plano = (Aeroplano) aeromobile;
                        textAreaString.append(plano).append("\n");
                    }
                }
                break;
            case 1:
                for(Aeromobile aeromobile:aeromobiles){
                    if(aeromobile.getClass().equals(Elicottero.class)){
                        Elicottero elicottero = (Elicottero) aeromobile;
                        textAreaString.append(elicottero).append("\n");
                    }
                }
                break;
            case 2:
                for(Aeromobile aeromobile:aeromobiles){
                    if(aeromobile.getClass().equals(Aeroplano.class)){
                        Aeroplano plano = (Aeroplano) aeromobile;
                        textAreaString.append(plano).append("\n");
                    }
                    else {
                        Elicottero elicottero = (Elicottero) aeromobile;
                        textAreaString.append(elicottero).append("\n");
                    }
                }
                break;
        }
        textArea.setText(textAreaString.toString());
    }
}
