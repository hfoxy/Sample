package uk.hfox.gendis;

import org.junit.jupiter.api.Test;
import uk.hfox.gendis.minigame.*;

import static org.junit.jupiter.api.Assertions.*;

class GendisConverterMinigameTest {

    @Test
    void add() {
        GendisConverterMinigame converter = new GendisConverterMinigameImpl();
        GendisMinigameFizzBuzz fizzbuzz = new GendisMinigameFizzBuzz();
        converter.add(fizzbuzz);

        assertTrue(converter.has(fizzbuzz));
        assertTrue(converter.has(fizzbuzz.getKey()));

        GendisMinigameFuzzBizz fuzzbizz = new GendisMinigameFuzzBizz();
        assertFalse(converter.add(fuzzbizz));
        assertFalse(converter.has(fuzzbizz));

        SampleFizzBuzz sample = new SampleFizzBuzz(fizzbuzz.getKey(), 1, "Fizz", "Buzz");
        assertFalse(converter.add(sample));
        assertFalse(converter.has(sample));
    }

    @Test
    void remove() {
        GendisConverterMinigame converter = new GendisConverterMinigameImpl();
        GendisMinigameFizzBuzz fizzbuzz = new GendisMinigameFizzBuzz();

        assertTrue(converter.add(fizzbuzz));
        assertTrue(converter.has(fizzbuzz));
        assertTrue(converter.has(fizzbuzz.getKey()));

        assertTrue(converter.remove(fizzbuzz));
        assertFalse(converter.has(fizzbuzz));

        assertTrue(converter.add(fizzbuzz));
        assertTrue(converter.has(fizzbuzz));

        assertTrue(converter.remove(fizzbuzz.getKey()));
        assertFalse(converter.has(fizzbuzz.getKey()));

        assertFalse(converter.remove(fizzbuzz.getKey()));
        assertFalse(converter.remove(fizzbuzz));
    }

    @Test
    void toStringFromInteger() {
        GendisConverterMinigame converter = new GendisConverterMinigameImpl();
        GendisMinigameFizzBuzz fizzbuzz = new GendisMinigameFizzBuzz();

        converter.add(fizzbuzz);
        assertTrue(converter.has(fizzbuzz));

        assertEquals("1", converter.toStringFromInteger(1));
        assertEquals("2", converter.toStringFromInteger(2));
        assertEquals("Fizz", converter.toStringFromInteger(3));
        assertEquals("Buzz", converter.toStringFromInteger(5));
        assertEquals("FizzBuzz", converter.toStringFromInteger(15));
        assertEquals("Fizz", converter.toStringFromInteger(18));
        assertEquals("Buzz", converter.toStringFromInteger(20));
        assertEquals("FizzBuzz", converter.toStringFromInteger(30));
    }

    @Test
    void multipleMinigameSupport() {
        GendisConverterMinigame converter = new GendisConverterMinigameImpl();

        GendisMinigame fizzbuzz = new GendisMinigameFizzBuzz();
        converter.add(fizzbuzz);
        assertTrue(converter.has(fizzbuzz));

        GendisMinigame fozzbozz = new GendisMinigameFozzBozz();
        converter.add(fozzbozz);
        assertTrue(converter.has(fozzbozz));

        for (int i = 0; i < 100; i++) {
            String response = converter.toStringFromInteger(i);
            if (i % 3 == 0 && i % 5 == 0) {
                assertEquals("FizzBuzz", response);
            } else if (i % 3 == 0) {
                assertEquals("Fizz", response);
            } else if (i % 5 == 0) {
                assertEquals("Buzz", response);
            } else if (i % 2 == 0) {
                assertEquals("Bozz", response);
            } else {
                assertEquals("Fozz", response);
            }
        }
    }

    public static class SampleFizzBuzz extends GenisMinigameFizzBuzzBasic {

        public SampleFizzBuzz(String key, int index, String fizz, String buzz) {
            super(key, index, fizz, buzz);
        }

    }

}