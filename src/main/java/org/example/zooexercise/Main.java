package org.example.zooexercise;

public class Main {
    public static void main(String[] args) {

        /*
            Creare un programma Java che possa gestire una serie di giardini zoologici

            Ogni parco deve poter contenere:
            -orario di apertura
            -numero di animali max (capienza)
            -deve indicare quali sezioni/spazi sono presenti fra questi 3:
                -RecintoAcquatico (può contenere solo animali acquatici)
            -RecintoVolatili (può contenere solo volatili)
                -RecintoStandard (può contenere il resto degli animali)
            -ogni sezione/spazio deve specificare:
                -lista degli animali presenti
                -orario di apertura del recinto (OGNI ZOO DEVE AVERE ORARI DIVERSI)

            Il programma  deve consentire ad un utente di consultare il registro di questi parchi per:
            1)	Cercare quali zoo contengono un certo tipo di animale
            2)	Selezionare uno zoo per capire se è aperto in questo momento
            3)	Cercare in modo specifico un certo animale in un certo zoo
            4)	Richiedere la possibilità di visitare un certo animale in un certo zoo all’interno di un recinto in questo momento
            5)	Stampare lista degli animali presenti in un certo zoo
            6)	Stampare lista degli animali presenti in un certo zoo per un certo sezione/spazio richiesto
         */


        /*
            ZOO
                .int  ->  numero max di animali
                .Time ->  orario di apertura
                .Time ->  orario di chiusura
            RECINTO
                .Time ->  orario di apertura
                .Time ->  orario di chiusura

                -> RECINTOACQUATICO
                    .List<Animali> animali
                -> RECINTOVOLATILI
                -> RECINTOSTANDARD

            ANIMALI
                . int numeroEsemplari
                . String nome
                . String cibo
                . Enum tipologia
                    ->CARNIVORO
                    ->ERBIVORO
                    ->ONNIVORO
                . RECINTO recinto

         */

        /*

            COMPLETARE MAIN CON
            1) POPOLARE DATI DELLO ZOO
            2) CREARE INTERFACCIA UTENTE
                PLUS-> CREARE N CLASSI CHE RAPPRESENTANO I VARI COMANDI

            3) INTEGRARE METODI A PIACERE (USARE TIPOLOGIA ANIMALE IN ANIMALE)
                ES: RITORNA LA LISTA DI TUTTI GLI ANIMALI CHE MATCHANO UNA TIPOLOGIA
         */




    }
}