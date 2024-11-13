package it.unisa.school;

public class Student extends Person {

    private int numberOfAbsences;

    public Student(String firstName, String lastName, int age, int numberOfAbsences) {
        super(firstName, lastName, age);
        this.numberOfAbsences = numberOfAbsences;
    }
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.numberOfAbsences = 0;
    }
    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }
    public void addNumberOfAbsences(int numberOfAbsences) {
        this.numberOfAbsences += numberOfAbsences;
    }

    public void removeNumberOfAbsences(int numberOfAbsences) {
        this.numberOfAbsences -= numberOfAbsences;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero di assenze=" + numberOfAbsences;
    }
}
