public class VendingMachine {
    private int numberOfCans;
    private int numberOfTokens;

    public VendingMachine() {
        numberOfCans = 0;
        numberOfTokens = 0;
    }

    public VendingMachine(int initialNumberOfCans) {
        numberOfCans = initialNumberOfCans;
        numberOfTokens = 0;
    }

    public void addCans(int numberOfNewCans) {
        numberOfCans += numberOfNewCans;
    }

    public void takeCan() {
        if(numberOfTokens > 0 && numberOfCans > 0) {
            numberOfCans--;
            numberOfTokens--;
        }
    }

    public void takeTokens() {
        numberOfTokens += 1;
    }

    public int getNumberOfCans() {
        return numberOfCans;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
}