public class Main {
    public static void main(String[] args) {
        contapersone a=new contapersone();
        a.incrementa();
        a.incrementa();
        a.incrementa();
        System.out.println(a.getN());
        a.reset();
        System.out.println(a.getN());
    }
}