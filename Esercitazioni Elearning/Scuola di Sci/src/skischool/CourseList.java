package skischool;

import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> corsi;
    public CourseList() {
        corsi = new ArrayList<>();
    }

    public void addCourse(Course c) {
        corsi.add(c);
        corsi.sort(Course::compareTo);
    }

    public Course getCourse(int i) {
        return corsi.get(i);
    }

    public Course removeCourse(int i) {
        return corsi.remove(i);
    }

    public ArrayList<Course> getCorsi() {
        return corsi;
    }

    public ArrayList<Course> getCourses(String type) {
        ArrayList<Course> res = new ArrayList<>();
        for (Course c : corsi) {
            if(c.getClass().getSimpleName().equals(type)) {
                res.add(c);
            }
        }
        return res;
    }
}
