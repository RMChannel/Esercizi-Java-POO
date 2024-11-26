import java.util.ArrayList;

public class CustomCollection<T extends Comparable<T>> {
    private ArrayList<T> collection;
    public CustomCollection() {
        collection = new ArrayList<>();
    }
    public void add(T value) {
        collection.add(value);
    }
    public void remove(int index) {
        if(index <0 || index >= collection.size()) throw new IndexOutOfBoundsException();
        collection.remove(index);
    }
    public int size() {
        return collection.size();
    }
    public Object get(int index) {
        return collection.get(index);
    }
    public static<T extends Comparable<T>> CustomCollection<T> merge(CustomCollection<T> c1, CustomCollection<T> c2) {
        CustomCollection<T> c = new CustomCollection<>();
        for(int i = 0; i < c1.size(); i++) {
            c.add((T) c1.get(i));
        }
        for(int i = 0; i < c2.size(); i++) {
            c.add((T) c2.get(i));
        }
        return c;
    }
    public T getMax() {
        T max = collection.get(0);
        for(int i = 1; i < collection.size(); i++) {
            if(max.compareTo(collection.get(i)) > 0) max = collection.get(i);
        }
        return max;
    }
    public void sort(java.util.Comparator<T> comparator) {
        collection.sort(comparator);
    }
}
