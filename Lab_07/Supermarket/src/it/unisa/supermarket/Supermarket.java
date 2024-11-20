package it.unisa.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import it.unisa.supermarket.ProductComparatorByPrice;
import java.util.List;

public class Supermarket {

    private final List<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        Comparator<Product> comparator = new ProductComparatorByCode();
        products.sort(comparator);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getProductType(int i) {
        return products.get(i).getClass().getSimpleName();
    }

    public Product getMinPrice() {
        Comparator<Product> comparator = new ProductComparatorByPrice();
        return products.stream().min(comparator).get();
    }

    public Product getMaxPrice() {
        Comparator<Product> comparator = new ProductComparatorByPrice();
        return products.stream().max(comparator).get();
    }

    public List<Product> find(String brand) {
        List<Product> found = new ArrayList<>();
        for(Product p : products) {
            if(p.getBrand().equals(brand)) {
                found.add(p);
            }
        }
        return found;
    }
}
