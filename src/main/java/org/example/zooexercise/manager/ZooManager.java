package org.example.zooexercise.manager;

import org.example.zooexercise.animali.Animale;
import org.example.zooexercise.exception.AnimalNotFoundException;
import org.example.zooexercise.exception.RecintoNotFoundException;
import org.example.zooexercise.exception.TipologiaRecintoNotFoundException;
import org.example.zooexercise.exception.ZooNotFoundException;
import org.example.zooexercise.recinto.Recinto;
import org.example.zooexercise.recinto.TipologiaRecinto;
import org.example.zooexercise.zoo.Zoo;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/*
            Il programma  deve consentire ad un utente di consultare il registro di questi parchi per:
            1)	Cercare quali zoo contengono un certo tipo di animale
            2)	Selezionare uno zoo per capire se è aperto in questo momento
            3)	Cercare in modo specifico un certo animale in un certo zoo
            4)	Richiedere la possibilità di visitare un certo animale in un certo zoo all’interno di un recinto in questo momento
            5)	Stampare lista degli animali presenti in un certo zoo
            6)	Stampare lista degli animali presenti in un certo zoo per un certo sezione/spazio richiesto

 */
public class ZooManager {

    private List<Zoo> zooList;

    public ZooManager(List<Zoo> zooList) {
        this.zooList = zooList;
    }


    public List<Zoo> findZooListByAnimalName(String nomeAnimale) {
        return zooList
                .stream()
                .filter(zoo -> zoo.getRecinti()
                        .stream()
                        .anyMatch(recinto -> recinto.getAnimaliList()
                                .stream()
                                .anyMatch(animale -> animale.getNome().equals(nomeAnimale))))
                .collect(Collectors.toList());

    }

    public boolean isZooOpenNow(String zooName) throws ZooNotFoundException {
        /*Optional<Zoo> zooResult=zooList.stream().filter(zoo -> zoo.getNome().equals(zooName)).findAny();
        if(!zooResult.isPresent()){
            //todo
        }*/
        Zoo zooResult = zooList.stream().filter(zoo -> zoo.getNome().equals(zooName)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + zooName));
        LocalTime now = LocalTime.now();
        if (zooResult.getOrarioDiApertura().isBefore(now) && zooResult.getOrarioDiChiusura().isAfter(now)) {
            return true;
        }
        return false;

    }

    /**
     * @param nomeAnimale
     * @param nomeZoo
     * @return optional di animale se presente nello zoo
     * @throws RuntimeException se lo zoo non è presente
     */
    public Optional<Animale> findOptionalAnimalByNameAndZoo(String nomeAnimale, String nomeZoo) throws ZooNotFoundException {
        Zoo zooResult = zooList.stream().filter(zoo -> zoo.getNome().equals(nomeZoo)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + nomeZoo));
        return zooResult.getRecinti()
                .stream()
                .flatMap(recinto -> recinto.getAnimaliList().stream())
                .filter(animale -> animale.getNome().equals(nomeAnimale))
                .findAny();
    }

    /**
     * @param nomeAnimale
     * @param nomeZoo
     * @return animale presente nello zoo
     * @throws RuntimeException se lo zoo o l'animale non sono presenti
     */
    public Animale findAnimalByNameAndZoo(String nomeAnimale, String nomeZoo) throws ZooNotFoundException, AnimalNotFoundException {
        Zoo zooResult = zooList.stream().filter(zoo -> zoo.getNome().equals(nomeZoo)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + nomeZoo));
        return zooResult.getRecinti()
                .stream()
                .flatMap(recinto -> recinto.getAnimaliList().stream())
                .filter(animale -> animale.getNome().equals(nomeAnimale))
                .findAny()
                .orElseThrow(() -> new AnimalNotFoundException("animal not found with name: " + nomeAnimale));
    }

    public boolean isAnimalVisibleInZooInRecintoNow(String nomeAnimale, String nomeZoo, String nomeRecinto) throws ZooNotFoundException, TipologiaRecintoNotFoundException, RecintoNotFoundException, AnimalNotFoundException {
        LocalTime now = LocalTime.now();
        Zoo zooResult = zooList.stream().filter(zoo -> zoo.getNome().equals(nomeZoo)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + nomeZoo));
        TipologiaRecinto tipologiaRecinto;

        try {
            tipologiaRecinto = TipologiaRecinto.valueOf(nomeRecinto);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new TipologiaRecintoNotFoundException("type not found with name: " + nomeRecinto);
        }

        Recinto recinto = zooResult.getRecinti().stream()
                .filter(r -> r.getTipologiaRecinto().equals(tipologiaRecinto))
                .findAny().orElseThrow(() -> new RecintoNotFoundException("recinto not found with name: " + nomeRecinto));
        if (recinto.getAnimaliList().stream().noneMatch(animale -> animale.getNome().equals(nomeAnimale))) {
            throw new AnimalNotFoundException("animal not found with name: " + nomeAnimale);
        }
        return recinto.getOrarioDiApertura().isBefore(now) && recinto.getOrarioDiChiusura().isAfter(now);
    }

    public List<Animale> findAnimalListByZoo(String zooName) throws ZooNotFoundException {
        Zoo zooResult = findFirstZooInMatch(zooName);
        return zooResult.getRecinti().stream().flatMap(recinto -> recinto.getAnimaliList().stream())
                .collect(Collectors.toList());
    }

    public List<Animale> findAnimalListByZooAndRecinto(String zooName, String recintoName) throws ZooNotFoundException, TipologiaRecintoNotFoundException, RecintoNotFoundException {
        Zoo zooResult = zooList.stream().filter(zoo -> zoo.getNome().equals(zooName)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + zooName));
        TipologiaRecinto tipologiaRecinto;

        try {
            tipologiaRecinto = TipologiaRecinto.valueOf(recintoName);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new TipologiaRecintoNotFoundException("type not found with name: " + recintoName);
        }
        Recinto recinto = zooResult.getRecinti().stream()
                .filter(r -> r.getTipologiaRecinto().equals(tipologiaRecinto))
                .findAny().orElseThrow(() -> new RecintoNotFoundException("recinto not found with name: " + recintoName));
        return recinto.getAnimaliList();
    }

    /************************ */
    private Zoo findFirstZooInMatch(String zooName) throws ZooNotFoundException {
        return zooList.stream().filter(zoo -> zoo.getNome().equals(zooName)).findAny().orElseThrow(() -> new ZooNotFoundException("zoo not found with name: " + zooName));
    }

}
