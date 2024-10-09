import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test
    public void test() {
        Locker locker = new Locker();
        Assert.assertTrue(locker.isOpen());
        locker.lock();
        Assert.assertTrue(locker.isOpen());
        locker.newComb("123");
        locker.lock();
        Assert.assertTrue(locker.isOpen());
        locker.newComb("abc");
        locker.lock();
        Assert.assertTrue(locker.isOpen());
        locker.newComb("ABC");
        locker.lock();
        Assert.assertFalse(locker.isOpen());
        locker.unlock("abc");
        Assert.assertFalse(locker.isOpen());
        locker.unlock("ABC");
        Assert.assertTrue(locker.isOpen());
    }
}