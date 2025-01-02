import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //CREAZIONE TEST FILE
        StudentCard student1 = new StudentCard(1, "Mario", "Rossi", true, "M12345",
                new GregorianCalendar(2025, 11, 31), 150.50, 'A', true);
        StudentCard student2 = new StudentCard(2, "Luca", "Bianchi", false, "M67890",
                new GregorianCalendar(2027, 5, 15), 75.00, 'B', false);
        StudentCard student3 = new StudentCard(3, "Giulia", "Verdi", true, "M54321",
                new GregorianCalendar(2026, 2, 28), 200.00, 'A', true);
        StudentCard student4 = new StudentCard(4, "Anna", "Neri", true, "M98765",
                new GregorianCalendar(2028, 10, 5), 50.25, 'A', false);
        StudentCard student5 = new StudentCard(5, "Paolo", "Gialli", false, "M45678",
                new GregorianCalendar(2025, 7, 20), 120.75, 'B', true);

        StaffCard staff1 = new StaffCard(101, "Marco", "Blu", true, "IT Department", 5000.00, "administrative");
        StaffCard staff2 = new StaffCard(102, "Sara", "Grigi", false, "HR Department", 3000.50, "professor");
        StaffCard staff3 = new StaffCard(103, "Elena", "Rossi", true, "Finance Department", 7000.75, "administrative");
        StaffCard staff4 = new StaffCard(104, "Giorgio", "Verdi", true, "Engineering", 4500.25, "professor");
        StaffCard staff5 = new StaffCard(105, "Lucia", "Bianchi", false, "Marketing", 2500.00, "administrative");

        //Creo il mealPayment
        MealPayment m = new MealPayment();
        m.addCard(student1);
        m.addCard(student2);
        m.addCard(student3);
        m.addCard(student4);
        m.addCard(student5);
        m.addCard(staff1);
        m.addCard(staff2);
        m.addCard(staff3);
        m.addCard(staff4);
        m.addCard(staff5);

        //Creo il file
        File file=new File("savedata.dat");
        if(file.exists()) file.delete();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}