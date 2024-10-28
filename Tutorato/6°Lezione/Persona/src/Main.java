import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int n=sc.nextInt();
        System.out.print("Inserisci il 1° nome: ");
        String nome=sc.next();
        Persona min = new Persona(nome);
        Persona max = new Persona(nome);
        for(int i=1;i<n;i++) {
            System.out.print("Inserisci il "+(i+1)+"° nome: ");
            nome=sc.next();
            Persona p=new Persona(nome);
                if(min.compareTo(p)>0) min=p;
                if(max.compareTo(p)<0) max=p;
        }
        System.out.println(min.getNome()+" "+max.getNome());
    }
}