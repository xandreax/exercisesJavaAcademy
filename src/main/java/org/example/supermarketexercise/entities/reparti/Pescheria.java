package org.example.supermarketexercise.entities.reparti;

import org.example.supermarketexercise.entities.Product;
import org.example.supermarketexercise.entities.Supermarket;

import java.util.List;

public class Pescheria extends Reparto {

    private static final TipologiaReparto TIPOLOGIA_REPARTO = TipologiaReparto.PESCHERIA;

    public Pescheria(Supermarket supermarket) {
        super(supermarket);
    }

    @Override
    public TipologiaReparto getTipologiaReparto() {
        return TIPOLOGIA_REPARTO;
    }
}
