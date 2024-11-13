package it.unisa.medicaltests;

public class Echocardiogram extends MedicalTest {

    public enum Variants {
        SIMPLE,
        WITH_CONTRAST,
        STRESS
    }

    private final Variants type;
    private final int patientAge;

    public Echocardiogram(String doctorName, Variants type, int patientAge) {
        super(doctorName,0);
        if(type == Variants.SIMPLE || type == Variants.STRESS) super.setCost(30);
        else super.setCost(45);
        this.type = type;
        this.patientAge = patientAge;
        if(patientAge >= 65) super.setCost((super.getCost()-((super.getCost()*20)/100)));
    }

    public Variants getType() {
        return type;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Echocardiogram{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", type=" + type +
                ", patientAge=" + patientAge +
                '}';
    }
}
