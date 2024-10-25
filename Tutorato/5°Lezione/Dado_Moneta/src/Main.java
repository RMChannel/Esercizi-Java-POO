import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Moneta> listMoneta=new ArrayList<>();
        ArrayList<Dado> listDado=new ArrayList<>();
        Random r = new Random();
        int counterMoneta=r.nextInt(100)+1;
        int counterDado=r.nextInt(100)+1;
        for(int i=0;i<counterMoneta;i++) {
            listMoneta.add(new Moneta());
        }
        for(int i=0;i<counterDado;i++) {
            listDado.add(new Dado());
        }
        for(int i=0;i<counterMoneta;i++) {
            String result;
            if(listMoneta.get(i).lancio()==0) result="Testa";
            else result="Croce";
            System.out.println("Lancio Moneta n°"+(i+1)+": "+result);
        }
        System.out.print("\n");
        for(int i=0;i<counterDado;i++) {
            System.out.println("Lancio Dado n°"+(i+1)+": "+listDado.get(i).lancio());
        }
        System.out.println("\nNumero lanci moneta: "+Moneta.getLanci()+"\nNumero lanci dado: "+Dado.getLanci());
    }
}