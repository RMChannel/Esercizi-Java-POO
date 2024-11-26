import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Biblioteca b = new Biblioteca();
        Libro libro = new Libro("Test","AutoreTest",6221519,1994);
        Manuale m= new Manuale("Programmazione 1","Professoressa",1581165198,2016,"Informatica",5,"Premium",true);
        b.addLibro(libro);
        b.addLibro(m);
        b.salva("dati.dat");
        b= Biblioteca.load("dati.dat");
        b.stampaLibri();
    }
}