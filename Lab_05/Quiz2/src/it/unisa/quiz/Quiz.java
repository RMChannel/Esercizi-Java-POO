package it.unisa.quiz;

public class Quiz implements Comparable {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.score, ((Quiz) o).score);
    }
}
