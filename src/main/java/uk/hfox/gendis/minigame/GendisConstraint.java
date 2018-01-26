package uk.hfox.gendis.minigame;

public interface GendisConstraint {

    /**
     * Checks if the constraint is satisfied with the input, for example a "Fizz" constraint
     * would be satisfied by input values that are multiples of 3.
     *
     * @param value The input to check
     * @return true if the constraint was satisfied, false otherwise
     */
    boolean isSatisfied(int value);

    /**
     * The string response to send if this constraint is satisfied
     *
     * @return The response to send
     */
    String getResponse();

}
