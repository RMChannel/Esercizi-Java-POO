import org.junit.Assert;
import org.junit.Test;

public class TesterStudente {
    @Test
    public void createStudentTest() {
        Studente s=new Studente("Roberto","Cito");
        Assert.assertEquals("Roberto",s.getNome());
        Assert.assertEquals("Cito",s.getCognome());
    }
    @Test
    public void averageAndSumTest() {
        Studente s=new Studente("Roberto","Cito");
        s.addQuiz(30);
        s.addQuiz(20);
        s.addQuiz(18);
        s.addQuiz(20);
        Assert.assertEquals(88,s.getTotalScore(),0);
        Assert.assertEquals(22,s.getAverageScore(),0);
    }
}