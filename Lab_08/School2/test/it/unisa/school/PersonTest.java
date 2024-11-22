package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }

    @Test
    public void checkName() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("", "Rossi", 1997, "aliros", "testPassword");});
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "", 1997, "aliros", "testPassword");});
    }

    @Test
    public void checkBirthYear() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "Rossi", 1897, "aliros", "testPassword");});
    }

    @Test
    public void checkUserAndPassword() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "Rossi", 1997, "ara", "testPassword");});
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "Rossi", 1997, "aliros", "ara");});
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "Rossi", 1997, "aliros", "ara bella");});
        Assert.assertThrows(IllegalArgumentException.class, () -> {Person p = new Person("Alice", "Rossi", 1997, "aliros bella", "ara");});
    }

    /* TODO */
}