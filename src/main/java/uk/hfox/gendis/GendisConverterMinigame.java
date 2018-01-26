package uk.hfox.gendis;

import uk.hfox.gendis.minigame.GendisMinigame;

public interface GendisConverterMinigame extends GendisConverter {

    /**
     * Attempts to add the supplied minigame to the list of supported minigames
     *
     * @param minigame The minigame to add
     * @return true if the add was successful, false if the item could not be added (eg; already exists)
     */
    boolean add(GendisMinigame minigame);

    /**
     * Attempts to remove the minigame with the supplied key
     * @param key The key to remove
     * @return true if the minigame was present and has been removed, false if the key could not be removed (eg; does not exist)
     */
    boolean remove(String key);

    /**
     * Attempts to remove the supplied minigame
     * @param minigame The minigame to remove
     * @return true if the minigame was present and has been removed, false if the minigame could not be removed (eg; key does not exist)
     */
    boolean remove(GendisMinigame minigame);

    /**
     * Checks if the supplied key is present in this converter
     * @param key The key to check presence of
     * @return true if the key is present, false otherwise
     */
    boolean has(String key);

    /**
     * Checks if the supplied minigame is present in this converter
     * @param minigame The minigame to check presence of
     * @return true if the minigame is present, false otherwise
     */
    boolean has(GendisMinigame minigame);

}
