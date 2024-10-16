import java.util.ArrayList;
import java.util.List;

public class Purse {

    /* TODO */

    private final List<Coin> coins;

    public Purse() {
        coins = new ArrayList<>();
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public boolean find(Coin coin) {
        for (Coin c : coins) {
            if(coin.equals(c)) return true;
        }
        return false;
    }

    public int count(Coin coin) {
        int n=0;
        for (Coin c : coins) {
            if(c.equals(coin)) n++;
        }
        return n;
    }

    public Coin getMinimum() {
        Coin min=new Coin("TEMPMIN",100);
        for(Coin c: coins) {
            if(c.getValue()<min.getValue()) min=c;
        }
        return min;
    }

    public Coin getMaximum() {
        Coin max=new Coin("TEMPMAX",0);
        for(Coin c: coins) {
            if(c.getValue()>max.getValue()) max=c;
        }
        return max;
    }

    public double getTotal() {
        double result=0;
        for(Coin c: coins) result+=c.getValue();
        return (double) Math.round(result * 100) /100;
    }

    public void remove(Coin coin) {
        coins.remove(coin);
    }

    public boolean hasCoin(Coin coin) {
        for(Coin c: coins) {
            if(c.equals(coin)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        int $=0, q=0, d=0, n=0, c=0;
        for(Coin coin: coins) {
            if(coin.getValue()==1) $+=1;
            else if(coin.getValue()==0.25) q+=1;
            else if(coin.getValue()==0.1) d+=1;
            else if(coin.getValue()==0.05) n+=1;
            else c+=1;
        }
        return "Purse[Dollar = "+$+", Quarter = "+q+", Dime = "+d+", Nickel = "+n+", Cent = "+c+"]";
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }
}