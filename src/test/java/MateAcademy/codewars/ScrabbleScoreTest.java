package MateAcademy.codewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScrabbleScoreTest {
    @Test
    public void basicTest() {
        assertEquals(0, ScrabbleScore.scrabbleScore(""), "For empty input");
        assertEquals(1, ScrabbleScore.scrabbleScore("a"), "For input \"a\"");
        assertEquals(4, ScrabbleScore.scrabbleScore("f"), "For input \"f\"");
        assertEquals(6, ScrabbleScore.scrabbleScore("street"), "For input \"street\"");
        assertEquals(1, ScrabbleScore.scrabbleScore(" a"), "For input \" a\"");
        assertEquals(6, ScrabbleScore.scrabbleScore("st re et"), "For input \"st re et\"");
        assertEquals(22, ScrabbleScore.scrabbleScore("quirky"), "For input \"quirky\"");
        assertEquals(20, ScrabbleScore.scrabbleScore("MULTIBILLIONAIRE"), "For input \"MULTIBILLIONAIRE\"");
        assertEquals(13, ScrabbleScore.scrabbleScore("alacrity"), "For input \"alacrity\"");
        assertEquals(6, ScrabbleScore.scrabbleScore("STREET"), "For input \"STREET\"");
    }
}
