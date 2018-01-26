package uk.hfox.gendis;

public class GendisConverterImpl implements GendisConverter {

    @Override
    public String toStringFromInteger(int input) {
        return Integer.toString(input);
    }

}
