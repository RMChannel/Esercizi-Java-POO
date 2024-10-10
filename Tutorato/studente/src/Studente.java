import java.util.ArrayList;
import java.util.List;

public class Studente {
    private String nome;
    private String cognome;
    List<Integer> quiz = new ArrayList<>();
    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void addQuiz(int score) {
        quiz.add(score);
    }
    public int getTotalScore() {
        int sum=0;
        for(int i : quiz) {
            sum+=i;
        }
        return sum;
    }
    public double getAverageScore() {
        double sum=0, count=0;
        for(int i : quiz) {
            count++;
            sum+=i;
        }
        return sum/count;
    }
}
