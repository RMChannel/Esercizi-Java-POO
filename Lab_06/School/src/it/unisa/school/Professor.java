package it.unisa.school;

public class Professor extends Person {

    private String topic;

    private double wage;

    public Professor(String firstName, String lastName, int age, String specialization, double wage) {
        super(firstName,lastName,age);
        this.topic = specialization;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Argomento='" + topic + '\'' +
                ", Stipendio=" + wage;
    }
}
