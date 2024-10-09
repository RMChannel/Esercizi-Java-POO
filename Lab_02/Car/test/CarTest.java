import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test
    public void testCar() {
        Car car=new Car(8.5);
        Assert.assertEquals(0,car.getGas(),0);
        car=new Car(10,8.5);
        Assert.assertEquals(10,car.getGas(),0);
        car.addGas(20);
        Assert.assertEquals(30,car.getGas(),0);
    }

    @Test
    public void drivingTest() {
        Car car=new Car(50,0.5);
        car.drive(20);
        Assert.assertEquals(40,car.getGas(),0);
        car.drive(100);
        Assert.assertEquals(0,car.getGas(),0);
    }
}