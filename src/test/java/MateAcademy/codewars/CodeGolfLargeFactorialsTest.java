package MateAcademy.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeGolfLargeFactorialsTest {

    @Test
    public void BasicTests() {
        assertEquals("1", CodeGolfLargeFactorials.f(1));
        assertEquals("120", CodeGolfLargeFactorials.f(5));
        assertEquals("362880", CodeGolfLargeFactorials.f(9));
        assertEquals("1307674368000", CodeGolfLargeFactorials.f(15));
        assertEquals("2432902008176640000", CodeGolfLargeFactorials.f(20));
    }
}
