import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CaricaFile extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton caricaButton;

    public CaricaFile() {
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setTitle("Carica File");
        setVisible(true);
        caricaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MealPayment mp;
                dispose();
                File file = new File(textField1.getText());
                if(!file.exists()){
                    JOptionPane.showMessageDialog(null, "File non trovato", "Errore File", JOptionPane.ERROR_MESSAGE);
                    new CaricaFile();
                    return;
                }
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    Object o=ois.readObject();
                    if(o.getClass().equals(MealPayment.class)){
                        mp = (MealPayment) o;
                    }
                    else throw new ClassNotFoundException();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                new GUI(mp);
            }
        });
    }

    public static void main(String[] args) {
        new CaricaFile();
    }
}
