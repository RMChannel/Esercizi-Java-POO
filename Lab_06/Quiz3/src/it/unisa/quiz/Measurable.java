package it.unisa.quiz;

public interface Measurable extends Comparable<Measurable> {
    double getMeasure();
    int compareTo(Measurable o);
}