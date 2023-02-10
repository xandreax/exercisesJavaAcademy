package org.example.supermarketexercise.entities.reparti;

import org.example.supermarketexercise.entities.Supermarket;

public class Macelleria extends Reparto{

    private static final TipologiaReparto TIPOLOGIA_REPARTO = TipologiaReparto.MACELLERIA;
    public Macelleria(Supermarket supermarket) {
        super( supermarket);
    }

    @Override
    public TipologiaReparto getTipologiaReparto() {
        return null;
    }

}
