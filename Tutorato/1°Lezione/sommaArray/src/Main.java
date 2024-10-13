import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inserisci i numeri: ");
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        int sum=0;
        for (int i = 0; i < num.length; i++) {
            int temp = Integer.parseInt(num[i]);
            if(i%2==0) sum+=temp;
            else sum-=temp;
        }
        System.out.println(sum);
    }
}