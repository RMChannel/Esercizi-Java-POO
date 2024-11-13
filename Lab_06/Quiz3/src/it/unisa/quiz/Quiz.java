package it.unisa.quiz;

public class Quiz implements Measurable {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    @Override
    public double getMeasure() {
        return score;
    }

    @Override
    public int compareTo(Measurable o) {
        if(o.getMeasure() < this.getMeasure()) return 1;
        else if(o.getMeasure() > this.getMeasure()) return -1;
        else return 0;
    }
}
