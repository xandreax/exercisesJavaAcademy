package org.example.supermarketexercise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrello {
    private List<Product> products;

    public Carrello() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void remove(Product product, int quantity) {
        if(product.getQuantity() <= quantity) {
            products.remove(product);
        }
        else{
            products = products.stream()
                    .filter(p -> p.getName().equals(product.getName()))
                    .map(p -> {
                        Product p2 = new Product(p);
                        p2.setQuantity(p.getQuantity() - quantity);
                        return p2;
                    })
                    .collect(Collectors.toList());
        }
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
