import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca implements Serializable {
    private ArrayList<Libro> listaLibro;
    public Biblioteca() {
        listaLibro = new ArrayList<>();
    }
    public void addLibro(Libro libro) {
        listaLibro.add(libro);
    }
    public void removeLibro(Libro libro) {
        if(!listaLibro.remove(libro)) {
            throw new IllegalArgumentException("Libro non trovato");
        }
    }
    public void stampaLibri() {
        for(Libro libro : listaLibro) {
            System.out.println(libro.toString());
        }
    }
    public void sort(Comparator<Libro> comparator) {
        listaLibro.sort(comparator);
    }
    public void salva(String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        for(Libro libro : listaLibro) {
            oos.writeObject(libro);
        }
    }
    public static Biblioteca load(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ArrayList<Libro> listaLibro = new ArrayList<>();
        while(true) {
            try {
                Libro libro = (Libro) ois.readObject();
                listaLibro.add(libro);
            }
            catch(EOFException e) {
                break;
            }
        }
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.listaLibro = listaLibro;
        return biblioteca;
    }
    public ArrayList<Libro> cerca(String titolo) {
        ArrayList<Libro> found = new ArrayList<>();
        for(Libro libro : listaLibro) {
            if(libro.getTitolo().toLowerCase().contains(titolo.toLowerCase())) {
                found.add(libro);
            }
        }
        return found;
    }
    public ArrayList<Libro> cerca(int ISBN) {
        ArrayList<Libro> found = new ArrayList<>();
        for(Libro libro : listaLibro) {
            if(libro.getISBN() == ISBN) {
                found.add(libro);
            }
        }
        return found;
    }
}