package skischool;

import java.util.GregorianCalendar;

public interface Course {
    String getCourseName();
    int getMinimumNumberOfParticipants();
    int getMaximumNumberOfParticipants();
    boolean addParticipant();
    boolean isCourseActivated();
    GregorianCalendar getStartDate();
    int compareTo(Course course);
    public String getId();
    public int getnPartecipanti();
    public GregorianCalendar getData();
    public int getDurata();
}
