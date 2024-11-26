public class Main {
    public static void main(String[] args) {
        CustomCollection<Book> cc = new CustomCollection<>();
        Book b1 = new Book("Minecraft","Mojang",2015);
        Book b2 = new Book("Divina Commedia","Dante Alighieri",1400);
        Book b3 = new Book("Java Programming","Java Programming",2000);
        cc.add(b1);
        cc.add(b2);
        cc.add(b3);
        System.out.println("Libro più recente: " + cc.getMax().toString());
        cc.sort(Book::compareTo);
        CollectionUtils.printCollection((CustomCollection<?>) cc);
    }
}