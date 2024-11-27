package it.unisa.carseller;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class CarSeller {
    private List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        cars = new ArrayList<>();
        try {
            while (scanner.hasNextLine()) {
                String brand = scanner.nextLine();
                String model = scanner.nextLine();
                int year = Integer.parseInt(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                cars.add(new Car(brand,model,year,price));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileAlreadyExistsException {
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
        for(Car car : cars) {
            printWriter.println(car.getBrand());
            printWriter.println(car.getModel());
            printWriter.println(car.getManufacturingYear());
            printWriter.println(car.getPrice());
        }
        printWriter.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        cars = new ArrayList<>();
        while (true) {
            try {
                Car car = (Car) objectInputStream.readObject();
                cars.add(car);
            }
            catch (EOFException ignored){
                break;
            };
        }
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        for(Car car : cars) {
            objectOutputStream.writeObject(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> returnCarByBrandAndModel(String brand, String model) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandModelAndYear(String brand, String model, int manufacturingYear) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandAModelYearAndPrice(String brand, String model, int manufacturingYear, int minPrice, int maxPrice) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear
                    && car.getPrice() >= minPrice
                    && car.getPrice() <= maxPrice) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}