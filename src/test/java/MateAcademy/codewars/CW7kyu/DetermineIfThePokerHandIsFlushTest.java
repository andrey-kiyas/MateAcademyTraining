package MateAcademy.codewars.CW7kyu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class DetermineIfThePokerHandIsFlushTest {
    @Test
    public void BasicTests() {

        assertEquals(true,DetermineIfThePokerHandIsFlush.CheckIfFlush(new String[]{"AS", "3S", "9S", "KS", "4S"}));
        assertEquals(false,DetermineIfThePokerHandIsFlush.CheckIfFlush(new String[]{"AD", "4S", "7H", "KC", "5S"}));
        assertEquals(false,DetermineIfThePokerHandIsFlush.CheckIfFlush(new String[]{"AD", "4S", "10H", "KC", "5S"}));
        assertEquals(true,DetermineIfThePokerHandIsFlush.CheckIfFlush(new String[]{"QD", "4D", "10D", "KD", "5D"}));
    }

}
