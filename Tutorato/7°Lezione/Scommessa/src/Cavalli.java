import java.util.ArrayList;

public class Cavalli {
    ArrayList<String> nomi;
    public Cavalli() {
        nomi = new ArrayList<>();
    }
    public Cavalli(ArrayList<String> nomi) {
        this.nomi = nomi;
    }
    public int GetN() {
        return nomi.size();
    }
    public void Add(String nome) {
        nomi.add(nome);
    }
    public void printCavalli() {
        for(String nome : nomi) {
            System.out.print(nome+", ");
        }
        System.out.println();
    }
}
