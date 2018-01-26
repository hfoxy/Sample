package uk.hfox.gendis.minigame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GendisMinigameFuzzBizzTest {

    @Test
    void getResponse() {
        GendisMinigameFuzzBizz minigame = new GendisMinigameFuzzBizz();

        assertFalse(minigame.hasResponse(1));
        assertThrows(IllegalArgumentException.class, () -> minigame.getResponse(1));

        for (int i = 1; i < 10; i++) {
            int fuzz = i * 3;
            int bizz = i * 5;

            assertEquals(fuzz % 5 == 0 ? "FuzzBizz" : "Fuzz", minigame.getResponse(fuzz));
            assertEquals(bizz % 3 == 0 ? "FuzzBizz" : "Bizz", minigame.getResponse(bizz));
        }
    }

}
