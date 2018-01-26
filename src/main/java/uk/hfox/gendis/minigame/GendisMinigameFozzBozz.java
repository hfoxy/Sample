package uk.hfox.gendis.minigame;

public class GendisMinigameFozzBozz extends GendisMinigameBasic {

    @Override
    public String getKey() {
        return "fozzbozz";
    }

    @Override
    public int getIndex() {
        return 10;
    }

    @Override
    public boolean hasResponse(int input) {
        return true;
    }

    @Override
    public String getResponse(int input) {
        if (input % 2 == 0) {
            return "Bozz";
        }

        return "Fozz";
    }

}
