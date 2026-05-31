package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/destroying-asteroids
 */

public class LC2126DestroyingAsteroids {
    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21})); // true
        System.out.println(asteroidsDestroyed(5, new int[]{4, 9, 23, 4}));      // false
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }
            currentMass += asteroid;
        }

        return true;
    }
}
