import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String input;
        JFrame frame = new JFrame();
        frame.setSize(300,400);
        frame.setTitle("TestGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input = JOptionPane.showInputDialog("Rosso: ");
        int red = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Verde: ");
        int green = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Blu: ");
        int blue = Integer.parseInt(input);
        Color fillColor = new Color(red, green, blue);
        QuadratoComponent quadratoComponent = new QuadratoComponent(fillColor);
        frame.add(quadratoComponent);
        frame.setVisible(true);
    }
}