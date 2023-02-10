package org.example.zooexercise.zoo;

import org.example.zooexercise.recinto.Recinto;

import java.time.LocalTime;
import java.util.List;

public class Zoo {

    private String nome;
    private LocalTime orarioDiApertura;
    private LocalTime orarioDiChiusura;
    private Integer numMaxAnimali;
    private List<Recinto> recinti;

    public Zoo(String nome,LocalTime orarioDiApertura, LocalTime orarioDiChiusura, Integer numMaxAnimali,List<Recinto> recinti) {
        this.nome=nome;
        this.orarioDiApertura = orarioDiApertura;
        this.orarioDiChiusura = orarioDiChiusura;
        this.numMaxAnimali = numMaxAnimali;
        this.recinti=recinti;
    }

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

    public Integer getNumMaxAnimali() {
        return numMaxAnimali;
    }

    public void setNumMaxAnimali(Integer numMaxAnimali) {
        this.numMaxAnimali = numMaxAnimali;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Recinto> getRecinti() {
        return recinti;
    }

    public void setRecinti(List<Recinto> recinti) {
        this.recinti = recinti;
    }
}
