import Hotel.Cliente;
import Hotel.Prenotazione;
import Hotel.Stanza;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //Creo i dati test
        Cliente cliente1 = new Cliente("Roberto","Cito","3314598571","4798415009494981189");
        Cliente cliente2 = new Cliente("Aleksandre","Cikviladze","3475580127","021989479100320");
        Cliente cliente3 = new Cliente("Arjel","Buzi","3207891457","9522448922113654789");
        Stanza stanza1 = new Stanza(170,1,1,"Frigo, condizionatore, telefono, bagno privato","08966178521");
        Stanza stanza2 = new Stanza(369,3,2,"Tutto","08911478223");
        Stanza stanza3 = new Stanza(182,1,3,"Essere gay","0892215784");
        Stanza stanza4 = new Stanza(325,3,1,"Frigo, condizionatore, telefono, bagno privato","089151184101");
        Stanza stanza5 = new Stanza(561,5,3,"Frigo, condizionatore, telefono, bagno privato","0891475647");
        Stanza stanza6 = new Stanza(457,4,2,"Frigo, condizionatore, telefono, bagno privato","08933271236");
        Prenotazione p1 = new Prenotazione(new GregorianCalendar(2024, Calendar.OCTOBER,28),new GregorianCalendar(2025, Calendar.AUGUST,1),cliente1,stanza1);
        Prenotazione p2 = new Prenotazione(new GregorianCalendar(2024, Calendar.OCTOBER,30),new GregorianCalendar(2025, Calendar.AUGUST,1),cliente2,stanza2);
        Prenotazione p3 = new Prenotazione(new GregorianCalendar(2024, Calendar.OCTOBER,31),new GregorianCalendar(2025, Calendar.AUGUST,1),cliente3,stanza3);
        //Creo gli arrayList da salvare
        ArrayList<Cliente> clienti = new ArrayList<Cliente>();
        ArrayList<Stanza> stanze = new ArrayList<Stanza>();
        ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
        clienti.add(cliente1);
        clienti.add(cliente2);
        clienti.add(cliente3);
        stanze.add(stanza1);
        stanze.add(stanza2);
        stanze.add(stanza3);
        stanze.add(stanza4);
        stanze.add(stanza5);
        stanze.add(stanza6);
        prenotazioni.add(p1);
        prenotazioni.add(p2);
        prenotazioni.add(p3);
        //Creo il file dove salvare i dati test
        File file = new File("savedata.dat");
        if(file.exists()) file.delete();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(clienti);
            objectOutputStream.writeObject(stanze);
            objectOutputStream.writeObject(prenotazioni);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}