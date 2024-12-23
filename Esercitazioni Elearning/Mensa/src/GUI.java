import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.NotActiveException;

public class GUI extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton pagaButton;
    private JLabel downLabel;
    private static MealPayment mealPayment;

    public GUI(MealPayment mp) {
        mealPayment = mp;
        setSize(400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GUI");
        setLocationRelativeTo(null);
        setContentPane(panel1);
        printTitle();
        setVisible(true);
        pagaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int code;
                try {
                    code=Integer.parseInt(textField1.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Inserisci un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (Card c:mealPayment.getCards()) {
                    if(c.getCodice()==code) {
                        try {
                            mealPayment.useCard(code);
                        } catch (ExpiredCardException ex) {
                            throw new RuntimeException(ex);
                        } catch (InsufficientBalanceException ex) {
                            throw new RuntimeException(ex);
                        } catch (NotActiveException ex) {
                            throw new RuntimeException(ex);
                        }
                        printTitle();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Inserisci un codice esistente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void printTitle() {
        downLabel.setText("Somma incassata: "+mealPayment.computeTotal()+"€");
    }
}
