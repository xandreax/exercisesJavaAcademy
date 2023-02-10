package org.example.zooexercise;

public interface Comando {

    TipologiaComando getComando();


    public enum TipologiaComando{

        COMANDO_1,
        COMANDO_2
    }
}


