package uk.hfox.gendis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GendisConverterTest {

    @Test
    void toStringFromInteger() {
        GendisConverter sample = new GendisConverterImpl();

        assertEquals("0", sample.toStringFromInteger(0));

        assertEquals("1", sample.toStringFromInteger(1));
        assertEquals("15", sample.toStringFromInteger(15));
        assertEquals("1111", sample.toStringFromInteger(1111));
        assertEquals("2147483647", sample.toStringFromInteger(2147483647));

        assertEquals("-10", sample.toStringFromInteger(-10));
        assertEquals("-14", sample.toStringFromInteger(-14));
        assertEquals("-1234", sample.toStringFromInteger(-1234));
        assertEquals("-2147483648", sample.toStringFromInteger(-2147483648));
    }

}