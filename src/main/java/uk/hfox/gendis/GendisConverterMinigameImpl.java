package uk.hfox.gendis;

import uk.hfox.gendis.minigame.GendisMinigame;

import java.util.*;

public class GendisConverterMinigameImpl implements GendisConverterMinigame {

    private Map<String, GendisMinigame> minigames;

    public GendisConverterMinigameImpl() {
        this.minigames = new HashMap<>();
    }

    @Override
    public boolean add(GendisMinigame minigame) {
        for (GendisMinigame value : this.minigames.values()) {
            if (value.getIndex() == minigame.getIndex()) {
                return false;
            }
        }

        if (!this.minigames.containsKey(minigame.getKey())) {
            this.minigames.put(minigame.getKey(), minigame);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(String key) {
        return this.minigames.remove(key) != null;
    }

    @Override
    public boolean remove(GendisMinigame minigame) {
        return this.minigames.remove(minigame.getKey(), minigame);
    }

    @Override
    public boolean has(String key) {
        return this.minigames.containsKey(key);
    }

    @Override
    public boolean has(GendisMinigame minigame) {
        return this.minigames.containsValue(minigame);
    }

    @Override
    public String toStringFromInteger(int input) {
        List<GendisMinigame> list = new ArrayList<>(this.minigames.values());
        list.sort(null); // sort using Comparable

        for (GendisMinigame minigame : list) {
            if (minigame.hasResponse(input)) {
                return minigame.getResponse(input);
            }
        }

        return Integer.toString(input);
    }

}
