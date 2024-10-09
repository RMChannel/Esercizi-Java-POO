import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstAndLastWord {

    private final List<String> stringList;

    public FirstAndLastWord(List<String> stringList) {
        this.stringList = stringList;
    }

    public void sort() {
        stringList.sort(String::compareTo);
    }

    public void sortIgnoreCase() {
        stringList.sort(String::compareToIgnoreCase);
    }

    public String getFirst() {
        return stringList.getFirst();
    }

    public String getLast() {
        return stringList.getLast();
    }

    public void scannerWords() {
        System.out.print("Inserisci il numero di parole che vuoi inserire: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++) {
            System.out.print("Inserisci la "+(i+1)+"° parole che vuoi inserire: ");
            String temp=scanner.next();
            stringList.add(temp);
        }
        sort();
    }

    public void scannerWordsIgnoreCase() {
        System.out.print("Inserisci il numero di parole che vuoi inserire: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++) {
            System.out.print("Inserisci la "+(i+1)+"° parole che vuoi inserire: ");
            String temp=scanner.next();
            stringList.add(temp);
        }
        sortIgnoreCase();
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        FirstAndLastWord firstAndLastWord = new FirstAndLastWord(stringList);
        firstAndLastWord.scannerWords();
        System.out.println(firstAndLastWord.stringList);
        stringList = new ArrayList<>();
        firstAndLastWord = new FirstAndLastWord(stringList);
        firstAndLastWord.scannerWordsIgnoreCase();
        System.out.println(firstAndLastWord.stringList);
    }
}