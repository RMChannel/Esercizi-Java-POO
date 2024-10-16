import org.junit.Assert;
import org.junit.Test;

public class PurseTest {

    @Test
    public void findTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Nickel",0.05);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertTrue(p.find(c1));
        Assert.assertTrue(p.find(c2));
        Assert.assertTrue(p.find(c3));
    }

    @Test
    public void countTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Dollar",1);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertEquals(2,p.count(c1),0);
        Assert.assertEquals(1,p.count(c3),0);
    }

    @Test
    public void minMaxTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Dollar",1);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertEquals(c1,p.getMaximum());
        Assert.assertEquals(c3,p.getMinimum());
    }

    @Test
    public void getTotalTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Nickel",0.05);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertEquals(1.15,p.getTotal(),0);
    }

    @Test
    public void addRemoveTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Nickel",0.05);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertTrue(p.find(c1));
        p.remove(c1);
        Assert.assertFalse(p.find(c1));
    }

    @Test
    public void hasCoinTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Dollar",1);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertTrue(p.hasCoin(c1));
        Assert.assertTrue(p.hasCoin(c2));
        Assert.assertTrue(p.hasCoin(c3));
    }

    @Test
    public void toStringTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Dollar",1);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        Assert.assertEquals(p.toString(),"Purse[Dollar = 2, Quarter = 0, Dime = 1, Nickel = 0, Cent = 0]");
    }

    @Test
    public void equalsTest() {
        Coin c1=new Coin("Dollar",1);
        Coin c2=new Coin("Nickel",0.05);
        Coin c3=new Coin("Dime", 0.10);
        Purse p=new Purse();
        p.add(c1);
        p.add(c2);
        p.add(c3);
        c2=new Coin("Dollar",1);
        c3=new Coin("Nickel",0.05);
        c1=new Coin("Dime", 0.10);
        Purse p2=new Purse();
        p2.add(c1);
        p2.add(c2);
        p2.add(c3);
        Assert.assertTrue(p.equals(p2));
        p2.remove(c1);
        Assert.assertFalse(p.equals(p2));
    }
}