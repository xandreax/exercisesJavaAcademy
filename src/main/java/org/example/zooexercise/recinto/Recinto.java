package org.example.zooexercise.recinto;

import org.example.zooexercise.animali.Animale;
import org.example.zooexercise.zoo.Zoo;

import java.time.LocalTime;
import java.util.List;

public abstract class Recinto {
    private LocalTime orarioDiApertura;
    private LocalTime orarioDiChiusura;
    private List<Animale> animaleList;
    private Zoo zoo ;

    public Recinto(LocalTime orarioDiApertura, LocalTime orarioDiChiusura, List<Animale> animaleList, Zoo zoo) {
        this.orarioDiApertura = orarioDiApertura;
        this.orarioDiChiusura = orarioDiChiusura;
        this.animaleList = animaleList;
        this.zoo = zoo;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public abstract TipologiaRecinto getTipologiaRecinto();

    public LocalTime getOrarioDiApertura() {
        return orarioDiApertura;
    }

    public void setOrarioDiApertura(LocalTime orarioDiApertura) {
        this.orarioDiApertura = orarioDiApertura;
    }

    public LocalTime getOrarioDiChiusura() {
        return orarioDiChiusura;
    }

    public void setOrarioDiChiusura(LocalTime orarioDiChiusura) {
        this.orarioDiChiusura = orarioDiChiusura;
    }

    public List<Animale> getAnimaliList() {
        return animaleList;
    }

    public void setAnimaliList(List<Animale> animaleList) {
        this.animaleList = animaleList;
    }
}
