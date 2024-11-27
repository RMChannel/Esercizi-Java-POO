package it.unisa.phonecompany;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;

public class PhoneCompanyTest {
    @Test
    public void testSolution() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        try {
            File file = Path.of("test/").resolve("testData.txt").toFile();
            phoneCompany.readUserDataFromFile(file);
            User user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            Assert.assertEquals(22.25, user1.getTotalCost(), 0);
            User user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            Assert.assertEquals(12.25, user2.getTotalCost(), 0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeUserDataToFileTest() {
        try {
            File file = Path.of("test/").resolve("testData.txt").toFile();
            PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
            phoneCompany.readUserDataFromFile(file);
            User user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            User user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            phoneCompany.writeUserDataToFile(file,true);
            phoneCompany.readUserDataFromFile(file);
            user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            Assert.assertEquals(1,user1.getCode(),0);
            Assert.assertEquals("Dario",user1.getName());
            Assert.assertEquals("Di Nucci",user1.getLastName());
            Assert.assertEquals(22.25, user1.getTotalCost(), 0);
            user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            Assert.assertEquals(2,user2.getCode(),0);
            Assert.assertEquals("Giulio",user2.getName());
            Assert.assertEquals("Cesare",user2.getLastName());
            Assert.assertEquals(12.25, user2.getTotalCost(), 0);
        }
        catch (FileNotFoundException | FileAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeSerializedDataToFileTest() {
        try {
            File file = Path.of("test/").resolve("testData.txt").toFile();
            PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
            phoneCompany.readUserDataFromFile(file);
            User user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            User user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            File file2 = new File("testData.dat");
            phoneCompany.writeSerializedDataToFile(file2);
            phoneCompany.readSerializedDataFromFile(file2);
            user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            Assert.assertEquals(1,user1.getCode(),0);
            Assert.assertEquals("Dario",user1.getName());
            Assert.assertEquals("Di Nucci",user1.getLastName());
            Assert.assertEquals(22.25, user1.getTotalCost(), 0);
            user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            Assert.assertEquals(2,user2.getCode(),0);
            Assert.assertEquals("Giulio",user2.getName());
            Assert.assertEquals("Cesare",user2.getLastName());
            Assert.assertEquals(12.25, user2.getTotalCost(), 0);
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}