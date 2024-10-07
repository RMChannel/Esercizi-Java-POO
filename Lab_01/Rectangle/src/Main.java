import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int width = 10;
        int height = 20;

        int newX = 5;
        int newY = 5;

        double area;
        double perimeter;

        Rectangle box = new Rectangle(x, y, width, height);
        box.setLocation(newX, newY);
        box.width+=box.width*3;
        area=box.height*box.width;
        perimeter=(box.height*2)+(box.width*2);
        System.out.println(box);
        System.out.println(area);
        System.out.println(perimeter);

    }
}