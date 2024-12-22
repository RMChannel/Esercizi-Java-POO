package skischool;

import java.util.GregorianCalendar;

public class SkiCourse implements Course, Comparable<Course> {
    private String id;
    private int nPartecipanti;
    private GregorianCalendar data;
    private int durata;

    public SkiCourse(String id, int nPartecipanti, GregorianCalendar data, int durata) throws BadArgumentException {
        if(durata < 0) throw new BadArgumentException("Durata negativa non valida");
        this.id = id;
        this.nPartecipanti = nPartecipanti;
        this.data = data;
        this.durata = durata;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getnPartecipanti() {
        return nPartecipanti;
    }

    @Override
    public GregorianCalendar getData() {
        return data;
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public String getCourseName() {
        return "Corso di sci";
    }

    @Override
    public int getMinimumNumberOfParticipants() {
        return 4;
    }

    @Override
    public int getMaximumNumberOfParticipants() {
        return 8;
    }

    @Override
    public boolean addParticipant() {
        if(nPartecipanti<4) {
            nPartecipanti++;
            return true;
        }
        return false;
    }

    @Override
    public boolean isCourseActivated() {
        return nPartecipanti >= 4;
    }

    @Override
    public GregorianCalendar getStartDate() {
        return data;
    }

    @Override
    public int compareTo(Course o) {
        return data.compareTo(o.getData());
    }
}