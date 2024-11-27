package it.unisa.phonecompany;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice, double smsPrice, double gbPrice) {
        this.users = new ArrayList<>();
        this.minutePrice = minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;
    }

    public List<User> getUsers() {
        return users;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        users = new ArrayList<>();
        while(scanner.hasNextLine()) {
            int code = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String lastName = scanner.nextLine();
            int usedMinutes = Integer.parseInt(scanner.nextLine());
            int usedSMS = Integer.parseInt(scanner.nextLine());
            double usedMB = Double.parseDouble(scanner.nextLine());
            User user = new User(code,name,lastName);
            user.setUsedMinutes(usedMinutes);
            user.setUsedSMS(usedSMS);
            user.setUsedMB(usedMB);
            users.add(user);
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(overwrite) {
            String path = file.getAbsolutePath();
            file.delete();
            file = new File(path);
        }
        else {
            if(!file.exists()) {
                throw new FileAlreadyExistsException("Il file già esiste");
            }
        }
        try {
            writeUserDataToFile(file);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for(User user : users) {
            printWriter.println(user.getCode());
            printWriter.println(user.getName());
            printWriter.println(user.getLastName());
            printWriter.println(user.getUsedMinutes());
            printWriter.println(user.getUsedSMS());
            printWriter.println(user.getUsedMB());
        }
        printWriter.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        while(true) {
            try {
                User user = (User) objectInputStream.readObject();
                users.add(user);
            }
            catch (EOFException exception) {
                break;
            }
        }
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        for(User user : users) {
            objectOutputStream.writeObject(user);
        }
    }

    public User findUserByCode(int code) {
        for (User user : this.users) {
            if (user.getCode() == code) {
                return user;
            }
        }
        return null;
    }

    public void computeUserCost(User user) {
        int usedMinutes = user.getUsedMinutes();
        int usedSMS = user.getUsedSMS();
        double usedMB = user.getUsedMB();
        user.setTotalCost(usedMinutes * minutePrice + usedSMS * smsPrice + usedMB * gbPrice / 1000);
    }
}
