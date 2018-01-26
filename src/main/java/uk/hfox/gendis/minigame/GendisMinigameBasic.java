package uk.hfox.gendis.minigame;

public abstract class GendisMinigameBasic implements GendisMinigame {

    @Override
    public int compareTo(GendisMinigame object) {
        return this.getIndex() - object.getIndex();
    }

}
