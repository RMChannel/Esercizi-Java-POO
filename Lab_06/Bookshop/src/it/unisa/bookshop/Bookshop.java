package it.unisa.bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bookshop {

    final private List<Book> bookshop;

    public Bookshop() {
        bookshop = new ArrayList<>();
    }

    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for(Book book : bookshop) {
            if(book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findByTitleContent(String titleContent) {
        List<Book> books = new ArrayList<>();
        for(Book book : bookshop) {
            if(book.getTitle().toLowerCase().contains(titleContent.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findMaxAvailable() {
        List<Book> books = new ArrayList<>();
        int max=0;
        for(Book book : bookshop) {
            if(book.getNumberOfCopies()==max) {
                books.add(book);
            }
            else if(book.getNumberOfCopies()>max) {
                max=book.getNumberOfCopies();
                books.removeAll(books);
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBelowAvailability(int threshold) {
        List<Book> books = new ArrayList<>();
        for(Book book : bookshop) {
            if(book.getNumberOfCopies()<threshold) {
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> getBookshop() {
        return bookshop;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()) {
            String typeOfBook = sc.nextLine();
            if(typeOfBook.equals("Book")) {
                bookshop.add(new Book(sc.nextLine(), sc.nextLine(), sc.nextLine(),Integer.parseInt(sc.nextLine())));
            }
            else if(typeOfBook.equals("AudioBook")) {
                bookshop.add(new AudioBook(sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()),sc.nextLine()));
            }
        }
    }

    public void addBook(Book book) {
        bookshop.add(book);
    }
}
