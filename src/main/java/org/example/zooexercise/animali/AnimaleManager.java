package org.example.zooexercise.animali;

import org.example.zooexercise.exception.AnimalNotFoundException;

import java.util.List;

public class AnimaleManager {

    public List<Animale> animali;

    public AnimaleManager(List<Animale> animali) {
        this.animali = animali;
    }

    public List<Animale> getAnimali() {
        return animali;
    }

    public void setAnimali(List<Animale> animali) {
        this.animali = animali;
    }

    public Animale getAnimaleByNameAndZoo (String nomeAnimale, String zooName) throws AnimalNotFoundException{
        return animali.stream()
                .filter(a -> a.getNome().equals(nomeAnimale))
                .filter(a -> a.getRecinto().getZoo().getNome().equals(zooName))
                .findAny().orElseThrow(() -> new AnimalNotFoundException("animale non presente in questo zoo"));
    }
}
