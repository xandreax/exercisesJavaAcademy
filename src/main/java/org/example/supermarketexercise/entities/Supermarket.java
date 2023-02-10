package org.example.supermarketexercise.entities;

import org.example.supermarketexercise.entities.reparti.Reparto;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {

    private String name;
    private List<Reparto> reparti;

    public Supermarket(String name) {
        this.name = name;
        this.reparti = new ArrayList<>();
    }

    public void addReparto(Reparto r){
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
        return "Supermarket "+ name;
    }
}
