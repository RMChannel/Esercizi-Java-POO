public class Car {
    private double gas;
    private final double consumptionRate;

    public Car(double consumptionRate2) {
        gas=0;
        consumptionRate=consumptionRate2;
    }

    public Car(double gas2, double consumptionRate2) {
        gas=gas2;
        consumptionRate=consumptionRate2;
    }

    public double getGas() {
        return gas;
    }

    public void addGas(double plusGas) {
        gas+=plusGas;
    }

    public void drive(double km) {
        gas-=km*consumptionRate;
        if(gas<0) gas=0;
    }
}