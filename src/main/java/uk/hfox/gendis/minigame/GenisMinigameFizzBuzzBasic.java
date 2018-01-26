package uk.hfox.gendis.minigame;

public class GenisMinigameFizzBuzzBasic extends GendisMinigameBasic {

    private final String key;
    private final int index;
    private final String fizz;
    private final String buzz;

    public GenisMinigameFizzBuzzBasic(String key, int index, String fizz, String buzz) {
        this.key = key;
        this.index = index;
        this.fizz = fizz;
        this.buzz = buzz;
    }

    public GenisMinigameFizzBuzzBasic(String key, String fizz, String buzz) {
        this(key, 0, fizz, buzz);
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasResponse(int input) {
        return input != 0 && input % 5 == 0 || input % 3 == 0;
    }

    @Override
    public String getResponse(int input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return this.fizz + this.buzz;
        } else if (input % 3 == 0) {
            return this.fizz;
        } else if (input % 5 == 0) {
            return this.buzz;
        }

        throw new IllegalArgumentException("input is not supported");
    }

}
