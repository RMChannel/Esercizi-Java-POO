import javax.swing.*;
import java.awt.*;

public class QuadratoComponent extends JComponent {
    Color fillColor;
    public QuadratoComponent(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void paintComponent(Graphics g) {
        int dimension=200;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(fillColor);
        Rectangle rect = new Rectangle((getWidth()-dimension)/2, (getHeight()-dimension)/2, dimension, dimension);
        g2.fillRect((getWidth()-dimension)/2, (getHeight()-dimension)/2, dimension, dimension);
        g2.draw(rect);
    }
}
