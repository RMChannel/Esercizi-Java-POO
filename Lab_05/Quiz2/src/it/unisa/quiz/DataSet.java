package it.unisa.quiz;

public class DataSet {

    private double sum;
    private double minimum;
    private double maximum;
    private int count;

    public DataSet() {
        count = 0;
        sum = 0;
        minimum = -1;
        maximum = -1;
    }

    public double getAverage() {
        if (count == 0) return 0;
        else return sum / count;
    }

    public double getMaximum() {
        return maximum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void add(Quiz q) {
        count++;
        double x=q.getMeasure();
        sum += x;
        if(minimum==-1) minimum = x;
        else if(x<minimum) minimum = x;
        if(maximum==-1) maximum = x;
        else if(x>maximum) maximum = x;
    }
}