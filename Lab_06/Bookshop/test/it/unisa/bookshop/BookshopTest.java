package it.unisa.bookshop;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookshopTest {

    @Test
    public void readLibraryTest() throws FileNotFoundException {
        Bookshop bookshop1 = new Bookshop();
        Bookshop bookshop2 = new Bookshop();
        bookshop2.addBook(new Book("Una voce di notte","Camilleri Andrea","Sellerio Editore Palermo",44));
        bookshop2.addBook(new Book("Cinquanta sfumature di grigio","James E. L.","Mondadori",21));
        bookshop2.addBook(new Book("Il corpo umano","Giordano Paolo","Mondadori",33));
        bookshop2.addBook(new Book("Sogni rossi","Mo Yan","Einaudi",11));
        bookshop2.addBook(new Book("Fai bei sogni","Gramellini Massimo","Longanesi",14));
        bookshop2.addBook(new AudioBook("Il corpo umano","Giordano Paolo","Mondadori",100,50,"mp3"));
        bookshop2.addBook(new AudioBook("Fai bei sogni","Gramellini Massimo","Longanesi",90,50,"mp3"));
        bookshop1.readUserDataFromFile(new File("C:\\Users\\robbe\\IdeaProjects\\Laboratorio di Object Oriented Programming in Java\\Lab_06\\Bookshop\\test\\testData.txt"));
        List<Book> books1=bookshop1.findBelowAvailability(1000);
        List<Book> books2=bookshop2.findBelowAvailability(1000);
        for(Book book:books1) {
            Assert.assertTrue(books2.contains(book));
        }
    }

    @Test
    public void findByAuthorTest() throws FileNotFoundException {
        Book book=new Book("Una voce di notte","Camilleri Andrea","Sellerio Editore Palermo",44);
        Bookshop bookshop=new Bookshop();
        bookshop.readUserDataFromFile(new File("C:\\Users\\robbe\\IdeaProjects\\Laboratorio di Object Oriented Programming in Java\\Lab_06\\Bookshop\\test\\testData.txt"));
        List<Book> books1=bookshop.findByAuthor("Camilleri Andrea");
        Assert.assertTrue(books1.contains(book));
    }

    @Test
    public void findByTitleContentTest() throws FileNotFoundException {
        Book b1=new Book("Fai bei sogni","Gramellini Massimo","Longanesi",14);
        Book b2=new Book("Sogni rossi","Mo Yan","Einaudi",11);
        Bookshop bookshop=new Bookshop();
        bookshop.readUserDataFromFile(new File("C:\\Users\\robbe\\IdeaProjects\\Laboratorio di Object Oriented Programming in Java\\Lab_06\\Bookshop\\test\\testData.txt"));
        List<Book> books=bookshop.findByTitleContent("sogni");
        Assert.assertTrue(books.contains(b1));
        Assert.assertTrue(books.contains(b2));
    }

    @Test
    public void findMaxAvailabilityTest() throws FileNotFoundException {
        Book maxBook=new AudioBook("Il corpo umano","Giordano Paolo","Mondadori",100,50,"mp3");
        Bookshop bookshop=new Bookshop();
        bookshop.readUserDataFromFile(new File("C:\\Users\\robbe\\IdeaProjects\\Laboratorio di Object Oriented Programming in Java\\Lab_06\\Bookshop\\test\\testData.txt"));
        List<Book> maxBooks=bookshop.findMaxAvailable();
        Assert.assertTrue(maxBooks.contains(maxBook));
        Assert.assertEquals(1, maxBooks.size(),0);
    }

    @Test
    public void findBelowAvailabilityTest() throws FileNotFoundException {
        Book b1=new Book("Fai bei sogni","Gramellini Massimo","Longanesi",14);
        Book b2=new Book("Sogni rossi","Mo Yan","Einaudi",11);
        Bookshop bookshop=new Bookshop();
        bookshop.readUserDataFromFile(new File("C:\\Users\\robbe\\IdeaProjects\\Laboratorio di Object Oriented Programming in Java\\Lab_06\\Bookshop\\test\\testData.txt"));
        List<Book> books=bookshop.findBelowAvailability(15);
        Assert.assertTrue(books.contains(b1));
        Assert.assertTrue(books.contains(b2));
        Assert.assertEquals(2, books.size(),0);
    }

}