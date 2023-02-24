package org.example.supermarketexercise.entities;

import java.util.List;

public class Supermarket {

    private String name;
    private List<Reparto> reparti;

    public void addReparto(Reparto r) {
        reparti.add(r);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reparto> getReparti() {
        return reparti;
    }

    public void setReparti(List<Reparto> reparti) {
        this.reparti = reparti;
    }

    @Override
    public String toString() {
        return "Supermarket " + name;
    }

    public static class SupermarketBuilder {

        private final Supermarket supermarket;

        private SupermarketBuilder() {
            this.supermarket = new Supermarket();
        }

        public static SupermarketBuilder builder() {
            return new SupermarketBuilder();
        }

        public SupermarketBuilder setName(String name) {
            this.supermarket.name = name;
            return this;
        }

        public SupermarketBuilder setReparti(List<Reparto> reparti) {
            this.supermarket.reparti = reparti;
            return this;
        }

        public Supermarket build() {
            return this.supermarket;
        }
    }
}
