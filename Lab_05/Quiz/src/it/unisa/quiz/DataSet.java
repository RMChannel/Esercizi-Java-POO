package it.unisa.quiz;

public class DataSet {

    private double sum;
    private Measurable minimum;
    private Measurable maximum;
    private int count;

    public DataSet() {
        sum = 0;
        minimum = null;
        maximum = null;
        count = 0;
    }

    public double getAverage() {
        return sum / count;
    }

    public Measurable getMaximum() {
        return maximum;
    }

    public Measurable getMinimum() {
        return minimum;
    }

    public void add(Measurable x) {
        count++;
        sum += x.getMeasure();
        if (minimum == null) {
            minimum = x;
        }
        else if(x.getMeasure() < minimum.getMeasure()) {
            minimum = x;
        }
        if (maximum == null) {
            maximum = x;
        }
        else if(x.getMeasure() > maximum.getMeasure()) {
            maximum = x;
        }
    }
}