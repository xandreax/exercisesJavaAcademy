package org.example.supermarketexercise.entities;

import java.util.Objects;

public class BuildReparto {

    public Reparto getReparto(TipologiaReparto tipologiaReparto){
        if (Objects.requireNonNull(tipologiaReparto) == TipologiaReparto.PESCHERIA) {
            return new RepartoWithTicket();
        }
        return new Reparto();
    }
}
