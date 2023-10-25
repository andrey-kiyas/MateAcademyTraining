package MateAcademy.codewars;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DinglemouseTest {

    @Test
    @Order(1)
    public void one() {
        assertArrayEquals(new int[]{1, 1}, Dinglemouse.ownedCatAndDog(15, 15));
    }

    @Test
    @Order(2)
    public void two() {
        assertArrayEquals(new int[]{2, 2}, Dinglemouse.ownedCatAndDog(24, 24));
    }

    @Test
    @Order(3)
    public void three() {
        assertArrayEquals(new int[]{10, 10}, Dinglemouse.ownedCatAndDog(56, 64));
    }

    @Test
    @Order(4)
    public void four() {
        assertArrayEquals(new int[]{13, 15}, Dinglemouse.ownedCatAndDog(71, 89));
    }

    @Test
    @Order(5)
    public void five() {
        assertArrayEquals(new int[]{0, 11}, Dinglemouse.ownedCatAndDog(14, 72));
    }

    @Test
    @Order(6)
    public void six() {
        assertArrayEquals(new int[]{9, 4}, Dinglemouse.ownedCatAndDog(53, 38));
    }

}
