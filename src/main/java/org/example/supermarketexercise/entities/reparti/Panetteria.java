package org.example.supermarketexercise.entities.reparti;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;

import java.util.List;

public class Panetteria extends Reparto {

    private static final TipologiaReparto TIPOLOGIA_REPARTO = TipologiaReparto.PANETTERIA;

    public Panetteria(Supermarket supermarket) {
        super(supermarket);
    }

    @Override
    public TipologiaReparto getTipologiaReparto() {
        return null;
    }
}
