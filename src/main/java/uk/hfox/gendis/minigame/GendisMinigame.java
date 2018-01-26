package uk.hfox.gendis.minigame;

public interface GendisMinigame extends Comparable<GendisMinigame> {

    /**
     * Returns the string key that represents this implementation, eg; "fizzbuzz"
     *
     * @return The string key
     */
    String getKey();

    /**
     * Returns the defined index that this minigame represents, used by GendisConverterMinigame
     * to determine the order in which minigame responses are to be checked. Lower numbers are run
     * first. Duplicate indexes imply a direct overlap. For example FizzBuzz and FuzzBizz.
     *
     * @return The index that this Minigame will hold
     */
    int getIndex();

    /**
     * Checks if this minigame is designed to give a response to the supplied input
     * @param input The input to check
     * @return true if this implementation has a response, false otherwise
     */
    boolean hasResponse(int input);

    /**
     * Gets a response for the supplied input, for example FizzBuzz game;
     *  - multiples of 3 would return "Fizz"
     *  - multiples of 5 would return "Buzz"
     *
     * @param input The input to build a response from
     * @return A string response for the supplied input
     *
     * @throws IllegalArgumentException If the supplied input is not valid for this implementation
     */
    String getResponse(int input);

}
