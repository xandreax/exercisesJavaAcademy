package org.example.zooexercise.animali;

import org.example.zooexercise.recinto.Recinto;

public class Animale {

    private Integer numeroEsemplari;
    private String nome;
    private String cibo;
    private TipologiaAnimale tipologiaAnimale;
    private Recinto recinto;

    public Animale(Integer numeroEsemplari, String nome, String cibo, TipologiaAnimale tipologiaAnimale, Recinto recinto) {
        this.numeroEsemplari = numeroEsemplari;
        this.nome = nome;
        this.cibo = cibo;
        this.tipologiaAnimale = tipologiaAnimale;
        this.recinto = recinto;
    }

    public Integer getNumeroEsemplari() {
        return numeroEsemplari;
    }

    public void setNumeroEsemplari(Integer numeroEsemplari) {
        this.numeroEsemplari = numeroEsemplari;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCibo() {
        return cibo;
    }

    public void setCibo(String cibo) {
        this.cibo = cibo;
    }

    public TipologiaAnimale getTipologiaAnimale() {
        return tipologiaAnimale;
    }

    public void setTipologiaAnimale(TipologiaAnimale tipologiaAnimale) {
        this.tipologiaAnimale = tipologiaAnimale;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }
}
