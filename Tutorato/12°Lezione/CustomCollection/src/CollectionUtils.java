public class CollectionUtils {
    public static void printCollection(CustomCollection<?> c) {
        for(int i=0; i<c.size(); i++) {
            System.out.println(c.get(i).toString());
        }
    }
}
