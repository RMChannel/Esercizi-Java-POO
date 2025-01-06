import TesseraSportiva.TesseraSportiva;
import Ticket.TicketSingolo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import TesseraSportiva.ListaPienaException;
import TesseraSportiva.AttivitaException;
import TesseraSportiva.TicketNonUsabileException;
import Ticket.TicketTorneo;

public class Test {
    public static void main(String[] args) {
        TesseraSportiva paris2024;
        File file=new File("savedata.dat");
        if(file.exists()){
            try {
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
                paris2024=(TesseraSportiva) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Qualcosa è andato a puttane con la lettura del file, porca madonna");
                return;
            }
        }
        else {
            Random rand = new Random();
            paris2024=new TesseraSportiva("Roberto","Cito");
            ArrayList<String> list=new ArrayList<>();
            list.add("Basket");
            list.add("Calcio");
            list.add("Tennis");
            list.add("Ping Pong");
            list.add("Football");
            list.add("Cricket");
            for(int i=0;i<4;) {
                try {
                    paris2024.addTicket(new TicketSingolo(list.get(rand.nextInt(list.size())),"località"+(i+1),rand.nextDouble(280)+20));
                    i++;
                } catch (ListaPienaException e) {
                    System.err.println("Ciò non dovrebbe accadere, nel caso, sparati");
                    return;
                }
                catch (AttivitaException _) {
                    System.err.println("AttivitaException");
                }
            }
            while (true) {
                try {
                    paris2024.addTicket(new TicketTorneo(list.get(rand.nextInt(list.size())),"località"+5,rand.nextDouble(280)+20));
                    break;
                } catch (ListaPienaException e) {
                    System.err.println("Ciò non dovrebbe accadere, nel caso, sparati");
                    return;
                }
                catch (AttivitaException _) {
                    System.err.println("AttivitaException");
                }
            }
            for(int i=0;i<10;i++) {
                try {
                    paris2024.utilizza(rand.nextInt(5));
                } catch (TicketNonUsabileException e) {
                    System.err.println("è capitato un biglietto già utilizzato");
                }
            }
        }
        new GUI(paris2024);
    }
}
