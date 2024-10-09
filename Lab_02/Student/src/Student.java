import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String firstName;
    private final String lastName;
    private final List<Exam> exams;

    public Student(String name, String lname) {
        firstName = name;
        lastName = lname;
        exams = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void registerExam(Exam exam) {
        exams.add(exam);
    }

    public double computeAverageGrade() {
        double media=0;
        int count=0;
        for (Exam exam : exams) {
            media+= exam.getGrade();
            count++;
        }
        return media/count;
    }
}