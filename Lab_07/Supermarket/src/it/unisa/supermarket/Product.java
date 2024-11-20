package it.unisa.supermarket;

import java.util.GregorianCalendar;

public abstract class Product {

    final private String code;
    final private String description;
    final private String brand;
    private double price;
    private boolean onSale;
    private double percentage;
    private GregorianCalendar lastOnSaleDay;

    public Product(String code, String description, String brand, double price) {
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.percentage = 100;
        this.onSale = false;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.percentage = 100;
    }

    public void putOnSale(double p, GregorianCalendar g) {
        this.lastOnSaleDay = g;
        this.percentage = p;
        this.price=this.price-((this.price*p)/100);
        this.onSale = true;
    }

    public void checkOnSale() {
        GregorianCalendar g = new GregorianCalendar();
        if(g.compareTo(this.lastOnSaleDay)>0) {
            this.onSale = false;
            this.price=(this.price*100)/(100-this.percentage);
            this.percentage = 100;
        }
    }

    public abstract boolean buy(int p);

}
