package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void toStringTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        Assert.assertEquals("Nome='Roberto', Cognome='Bianchi', Anno di nascita=2005, Numero di assenze=3",
                s.toString());
    }

    @Test
    public void notReallyExam() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        Assert.assertThrows(IllegalArgumentException.class, () -> {s.addExam("Test 1",17);});
        Assert.assertThrows(IllegalArgumentException.class, () -> {s.addExam("Test 2",34);});
    }

    @Test
    public void getNumberOfExams() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("Analisi",18);
        s.addExam("P1",30);
        s.addExam("PSD",30);
        Assert.assertEquals(3,s.getNumberOfPassedExams(),0);
    }

    @Test
    public void testAverageGrade() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("Analisi",18);
        s.addExam("P1",30);
        s.addExam("PSD",30);
        Assert.assertEquals(26,s.getAverageGrade(),0);
    }

}