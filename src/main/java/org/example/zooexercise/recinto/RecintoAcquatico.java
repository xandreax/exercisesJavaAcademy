package org.example.zooexercise.recinto;

import org.example.zooexercise.animali.Animale;
import org.example.zooexercise.zoo.Zoo;

import java.time.LocalTime;
import java.util.List;

public class RecintoAcquatico extends Recinto{
    private static final TipologiaRecinto TIPOLOGIA_RECINTO=TipologiaRecinto.RECINTOACQUATICO;

    public RecintoAcquatico(LocalTime orarioDiApertura, LocalTime orarioDiChiusura, List<Animale> animaleList, Zoo zoo) {
        super(orarioDiApertura,orarioDiChiusura, animaleList, zoo);
    }

    @Override
    public TipologiaRecinto getTipologiaRecinto() {
        return TIPOLOGIA_RECINTO;
    }
}
