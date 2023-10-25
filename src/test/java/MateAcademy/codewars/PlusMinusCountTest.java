package MateAcademy.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlusMinusCountTest {

    @Test
    @Order(1)
    public void one() {
        assertEquals(0, PlusMinusCount.signChange(new int[]{1, 3, 4, 5}));
    }

    @Test
    @Order(2)
    public void two() {
        assertEquals(2, PlusMinusCount.signChange(new int[]{1, -3, -4, 0, 5}));
    }

    @Test
    @Order(3)
    public void three() {
        assertEquals(0, PlusMinusCount.signChange(new int[]{}));
    }

    @Test
    @Order(4)
    public void four() {
        assertEquals(3, PlusMinusCount.signChange(new int[]{-47, 84, -30, -11, -5, 74, 77}));
    }

//    @Test
//    public void basicTest() {
//        assertEquals(0, PlusMinusCount.signChange(new int[]{1, 3, 4, 5}));
//        assertEquals(2, PlusMinusCount.signChange(new int[]{1, -3, -4, 0, 5}));
//        assertEquals(0, PlusMinusCount.signChange(new int[]{}));
//        assertEquals(3, PlusMinusCount.signChange(new int[]{-47, 84, -30, -11, -5, 74, 77}));
//    }
}
