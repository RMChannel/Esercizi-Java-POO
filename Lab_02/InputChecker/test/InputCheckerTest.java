import org.junit.Assert;
import org.junit.Test;

public class InputCheckerTest {
    @Test
    public void testInputChecker() {
        InputChecker ic = new InputChecker();
        Assert.assertEquals("OK",ic.checkInput("S"));
        Assert.assertEquals("OK",ic.checkInput("SI"));
        Assert.assertEquals("OK",ic.checkInput("OK"));
        Assert.assertEquals("OK",ic.checkInput("certo"));
        Assert.assertEquals("Fine",ic.checkInput("N"));
        Assert.assertEquals("Fine",ic.checkInput("No"));
        Assert.assertEquals("Dato non corretto",ic.checkInput("F"));
    }
}