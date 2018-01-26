package uk.hfox.gendis.minigame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GendisMinigameConstraintTest {

    @Test
    void getResponse() {
        FizzConstraint fizzConst = new FizzConstraint();
        BuzzConstraint buzzConst = new BuzzConstraint();

        List<GendisConstraint> constraints = new ArrayList<>();
        constraints.add(fizzConst);
        constraints.add(buzzConst);

        GendisMinigameConstraint fbMulti = new GendisMinigameConstraint("fizzbuzz", 0, true, constraints);
        assertEquals("fizzbuzz", fbMulti.getKey());
        assertEquals(0, fbMulti.getIndex());

        assertFalse(fbMulti.hasResponse(1));
        assertThrows(IllegalArgumentException.class, () -> fbMulti.getResponse(1));

        for (int i = 1; i < 10; i++) {
            int fizz = i * 3;
            int buzz = i * 5;

            assertTrue(fbMulti.hasResponse(fizz));
            assertTrue(fbMulti.hasResponse(buzz));
            assertEquals(fizz % 5 == 0 ? "FizzBuzz" : "Fizz", fbMulti.getResponse(fizz));
            assertEquals(buzz % 3 == 0 ? "FizzBuzz" : "Buzz", fbMulti.getResponse(buzz));
        }

        GendisMinigameConstraint fbSingle = new GendisMinigameConstraint("fizzbuzz", 0, false, fizzConst, buzzConst);
        assertEquals("fizzbuzz", fbMulti.getKey());
        assertEquals(0, fbMulti.getIndex());

        assertFalse(fbSingle.hasResponse(1));
        assertThrows(IllegalArgumentException.class, () -> fbSingle.getResponse(1));

        for (int i = 1; i < 10; i++) {
            int fizz = i * 3;
            int buzz = i * 5;

            assertTrue(fbMulti.hasResponse(fizz));
            assertTrue(fbMulti.hasResponse(buzz));
            assertEquals("Fizz", fbSingle.getResponse(fizz), "input value: " + i);
            assertEquals(buzz % 3 == 0 ? "Fizz" : "Buzz", fbSingle.getResponse(buzz), "input value: " + i);
        }
    }

    public static class FizzConstraint implements GendisConstraint {

        @Override
        public boolean isSatisfied(int value) {
            return value != 0 && value % 3 == 0;
        }

        @Override
        public String getResponse() {
            return "Fizz";
        }

    }

    public static class BuzzConstraint implements GendisConstraint {

        @Override
        public boolean isSatisfied(int value) {
            return value != 0 && value % 5 == 0;
        }

        @Override
        public String getResponse() {
            return "Buzz";
        }

    }

}
