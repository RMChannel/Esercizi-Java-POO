import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
  @Test
  public void initialization() {
    VendingMachine vm = new VendingMachine();
    Assert.assertEquals(0,vm.getNumberOfCans(),0);
    Assert.assertEquals(0,vm.getNumberOfTokens(),0);
    vm=new VendingMachine(10);
    Assert.assertEquals(10,vm.getNumberOfCans(),0);
    Assert.assertEquals(0,vm.getNumberOfTokens(),0);
  }

  @Test
  public void addingAndRemoving() {
    VendingMachine vm = new VendingMachine();
    vm.addCans(10);
    Assert.assertEquals(10,vm.getNumberOfCans(),0);
    vm.takeTokens();
    vm.takeTokens();
    vm.takeTokens();
    Assert.assertEquals(3,vm.getNumberOfTokens(),0);
    vm.takeCan();
    Assert.assertEquals(2,vm.getNumberOfTokens(),0);
    Assert.assertEquals(9,vm.getNumberOfCans(),0);
  }

  @Test
  public void weArePoor() {
    VendingMachine vm = new VendingMachine(10);
    vm.takeCan();
    Assert.assertEquals(10,vm.getNumberOfCans(),0);
    vm=new VendingMachine();
    vm.takeTokens();
    vm.takeCan();
    Assert.assertEquals(1,vm.getNumberOfTokens(),0);
  }
}