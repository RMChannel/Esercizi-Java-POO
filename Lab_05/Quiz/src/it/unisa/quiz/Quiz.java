package it.unisa.quiz;

public class Quiz implements Measurable {

    private double punteggio;
    public Quiz(double punteggio) {
        this.punteggio = punteggio;
    }
    public double getMeasure() {
        return punteggio;
    }
}
