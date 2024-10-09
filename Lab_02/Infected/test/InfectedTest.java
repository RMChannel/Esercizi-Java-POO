import org.junit.Assert;
import org.junit.Test;

public class InfectedTest {

    @Test
    public void testCreate() {
        Infected disease=new Infected("Covid 19");
        Assert.assertEquals("Covid 19",disease.getDisease());
        disease=new Infected("Covid 20",50);
        Assert.assertEquals("Covid 20",disease.getDisease());
        Assert.assertEquals(50,disease.getNumberOfInfected(),0);
    }

    @Test
    public void testRt() {
        Infected disease=new Infected("Covid 19",50);
        disease.updateInfectedByRt(1.2);
        Assert.assertEquals(60,disease.getNumberOfInfected(),0);
    }
}