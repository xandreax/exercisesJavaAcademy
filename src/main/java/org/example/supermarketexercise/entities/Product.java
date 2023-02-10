package org.example.supermarketexercise.entities;

import org.example.supermarketexercise.entities.reparti.Reparto;

public class Product {
    private String name;
    private float price;
    private int quantity;
    private Reparto reparto;

    public Product(String name, float price, int quantity, Reparto reparto) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reparto = reparto;
    }

    public Product (Product p){
        this.name = p.getName();
        this.quantity = p.getQuantity();
        this.price = p.getPrice();
        this.reparto = p.getReparto();
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " price=" + price +
                ", quantity=" + quantity +
                ", reparto=" + reparto;
    }
}
