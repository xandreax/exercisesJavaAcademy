package org.example.supermarketexercise.entities;

import java.util.List;

public class Reparto {

    private List<Product> products;
    private Supermarket supermarket;
    private TipologiaReparto tipologiaReparto;

    public TipologiaReparto getTipologiaReparto(){
        return tipologiaReparto;
    };

    public List<Product> getProducts() {
        return products;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class RepartoBuilder{

        private final Reparto reparto;

        private RepartoBuilder(){
            this.reparto = new Reparto();
        }

        public static RepartoBuilder builder() {
            return new RepartoBuilder();
        }

        public RepartoBuilder setSupermarket(Supermarket supermarket) {
            this.reparto.supermarket = supermarket;
            return this;
        }

        public RepartoBuilder setProducts(List<Product> products) {
            this.reparto.products = products;
            return this;
        }

        public RepartoBuilder setTipologia(TipologiaReparto tipologia) {
            this.reparto.tipologiaReparto = tipologia;
            return this;
        }

        public Reparto build() {
            return this.reparto;
        }
    }
}
