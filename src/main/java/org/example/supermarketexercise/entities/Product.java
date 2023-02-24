package org.example.supermarketexercise.entities;

public class Product {
    private String name;
    private float price;
    private int quantity;
    private Reparto reparto;

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

    public static class ProductBuilder{

        private final Product product;

        private ProductBuilder() {
            this.product = new Product();
        }

        public static ProductBuilder builder() {
            return new ProductBuilder();
        }

        public ProductBuilder setName(String name){
            this.product.name = name;
            return this;
        }

        public ProductBuilder setPrice(float price){
            this.product.price = price;
            return this;
        }

        public ProductBuilder setQuantity (int quantity){
            this.product.quantity = quantity;
            return this;
        }

        public ProductBuilder setReparto (Reparto reparto){
            this.product.reparto = reparto;
            return this;
        }

        public Product build(){
            return this.product;
        }
    }
}
