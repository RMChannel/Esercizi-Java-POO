import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    @Test
    public void createStudent() {
        Student st=new Student("Roberto", "Cito");
        Assert.assertEquals("Roberto",st.getFirstName());
        Assert.assertEquals("Cito",st.getLastName());
        Assert.assertEquals(new ArrayList<>(),st.getExams());
    }

    @Test
    public void media() {
        Student st=new Student("Roberto", "Cito");
        st.registerExam(new Exam("PSD",new GregorianCalendar(2024, 6, 20),30));
        st.registerExam(new Exam("P1",new GregorianCalendar(2024, 1, 10),30));
        st.registerExam(new Exam("MMI",new GregorianCalendar(2024, 7, 7),20));
        st.registerExam(new Exam("PSD",new GregorianCalendar(2024, 9, 18),18));
        Assert.assertEquals(24.5,st.computeAverageGrade(),0);
    }
}