package uk.hfox.gendis;

public interface GendisConverter {

    /**
     * Converts the supplied input into a string
     *
     * @param input The input to convert
     * @return The converted input in String format
     */
    String toStringFromInteger(int input);

}
