package uk.hfox.gendis.minigame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GendisMinigameFozzBozzTest {

    @Test
    void getResponse() {
        GendisMinigameFozzBozz minigame = new GendisMinigameFozzBozz();

        for (int i = 1; i < 100; i++) {
            String result = minigame.getResponse(i);
            assertTrue(minigame.hasResponse(i));
            assertEquals(i % 2 == 0 ? "Bozz" : "Fozz", result);
        }
    }

}
