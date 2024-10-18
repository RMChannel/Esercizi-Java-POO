import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("C:\\Users\\robbe\\IdeaProjects\\Agenti\\src\\file.txt");
        Scanner scanner=new Scanner(file);
        int operations=0;
        double acquisti=0, vendite=0;
        while (scanner.hasNextLine()) {
            String name=scanner.next();
            double price=Double.parseDouble(scanner.next());
            int quantity=scanner.nextInt();
            char type=scanner.next().charAt(0);
            operations++;
            if(type=='B') acquisti+=price*quantity;
            else vendite+=price*quantity;
            Action action=new Action(name, price, quantity, type); //Non serve a niente
        }
        System.out.println("Op: "+operations+" Buy: "+acquisti+" Sell: "+vendite);
    }
}