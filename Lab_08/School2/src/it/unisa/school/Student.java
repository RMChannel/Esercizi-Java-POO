package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;

public class Student extends Person {

    private String matricola;
    private int numberOfAbsences;
    private HashMap<String, Integer> esami;

    public Student(String name, String surname, int birthYear,  String userId, String password, String matricola, int numberOfAbsences) {
        super(name, surname, birthYear,userId,password);
        if(matricola==null || matricola.isEmpty()) {
            throw new IllegalArgumentException("Matricola dello studente con formato errato");
        }
        this.matricola = matricola;
        this.numberOfAbsences = numberOfAbsences;
        this.esami = new HashMap<>();
    }

    public String getMatricola() {
        return matricola;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if(grade<18 || grade>31) throw new IllegalArgumentException("Voto non valido (minore di 18 o maggiore di 30 e lode");
        esami.put(examName, grade);
    }

    public int getNumberOfPassedExams() {
        return esami.size();
    }



    public double getAverageGrade() {
        int media=0, count=0;
        for(int n: esami.values()) {
            System.out.println(n);
            media+=n;
            count++;
        }
        return (double)media/count;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
