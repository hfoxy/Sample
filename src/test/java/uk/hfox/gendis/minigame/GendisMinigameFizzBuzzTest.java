package uk.hfox.gendis.minigame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GendisMinigameFizzBuzzTest {

    @Test
    void getResponse() {
        GendisMinigameFizzBuzz minigame = new GendisMinigameFizzBuzz();

        assertFalse(minigame.hasResponse(1));
        assertThrows(IllegalArgumentException.class, () -> minigame.getResponse(1));

        for (int i = 1; i < 10; i++) {
            int fizz = i * 3;
            int buzz = i * 5;

            assertEquals(fizz % 5 == 0 ? "FizzBuzz" : "Fizz", minigame.getResponse(fizz));
            assertEquals(buzz % 3 == 0 ? "FizzBuzz" : "Buzz", minigame.getResponse(buzz));
        }
    }

}
