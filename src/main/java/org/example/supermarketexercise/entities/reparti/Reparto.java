package org.example.supermarketexercise.entities.reparti;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;

import java.util.ArrayList;
import java.util.List;

public abstract class Reparto {

    private List<Product> products;
    private Supermarket supermarket;

    protected Reparto(Supermarket supermarket) {
        this.products = new ArrayList<>();
        this.supermarket = supermarket;
    }

    public abstract TipologiaReparto getTipologiaReparto();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
}
