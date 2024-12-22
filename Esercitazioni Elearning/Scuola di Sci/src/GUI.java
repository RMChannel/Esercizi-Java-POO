import skischool.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class GUI extends JFrame {
    private static CourseList list;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton elencaButton;
    private JTextArea textArea1;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestione corsi");
        setContentPane(panel1);
        setSize(600,300);
        setLocationRelativeTo(null);
        setVisible(true);

        elencaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                printCourse(comboBox1.getSelectedIndex());
            }
        });
    }

    private void printCourse(int i) {
        String searchCode;
        if(i==0) {
            searchCode = "SnowboardCourse";
        }
        else {
            searchCode = "SkiCourse";
        }
        for(Course c:list.getCourses(searchCode)) {
            LocalDate date = c.getStartDate().toZonedDateTime().toLocalDate();
            textArea1.append(c.getId()+" - "+c.getnPartecipanti()+" partecipanti - inizio "+date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear()+" - durata "+c.getDurata()+" gg\n");
        }
    }

    public static void main(String[] args) throws BadArgumentException {
        list = new CourseList();
        SkiCourse skiCourse1 = new SkiCourse("SC001", 6, new GregorianCalendar(2024, 0, 15), 7);
        SkiCourse skiCourse2 = new SkiCourse("SC002", 8, new GregorianCalendar(2024, 1, 10), 5);
        SkiCourse skiCourse3 = new SkiCourse("SC003", 4, new GregorianCalendar(2024, 2, 20), 10);
        SkiCourse skiCourse4 = new SkiCourse("SC004", 5, new GregorianCalendar(2024, 3, 5), 6);
        SkiCourse skiCourse5 = new SkiCourse("SC005", 7, new GregorianCalendar(2024, 4, 25), 8);
        SnowboardCourse snowboardCourse1 = new SnowboardCourse("SB001", 6, new GregorianCalendar(2024, 0, 25), 3);
        SnowboardCourse snowboardCourse2 = new SnowboardCourse("SB002", 9, new GregorianCalendar(2024, 1, 5), 4);
        SnowboardCourse snowboardCourse3 = new SnowboardCourse("SB003", 7, new GregorianCalendar(2024, 2, 15), 5);
        SnowboardCourse snowboardCourse4 = new SnowboardCourse("SB004", 10, new GregorianCalendar(2024, 3, 10), 6);
        SnowboardCourse snowboardCourse5 = new SnowboardCourse("SB005", 8, new GregorianCalendar(2024, 4, 20), 7);

        list.addCourse(skiCourse1);
        list.addCourse(skiCourse2);
        list.addCourse(skiCourse3);
        list.addCourse(skiCourse4);
        list.addCourse(skiCourse5);
        list.addCourse(snowboardCourse1);
        list.addCourse(snowboardCourse2);
        list.addCourse(snowboardCourse3);
        list.addCourse(snowboardCourse4);
        list.addCourse(snowboardCourse5);

        new GUI();
    }
}
