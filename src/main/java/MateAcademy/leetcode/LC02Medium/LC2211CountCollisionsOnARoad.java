package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-collisions-on-a-road
 */

public class LC2211CountCollisionsOnARoad {
    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL")); // 5
        System.out.println(countCollisions("LLRR"));   // 0
    }

    public static int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        while (left < n && directions.charAt(left) == 'L') left++;

        while (right >= 0 && directions.charAt(right) == 'R') right--;

        int collisions = 0;
        for (int i = left; i <= right; i++) {
            char c = directions.charAt(i);
            if (c == 'L' || c == 'R') collisions++;
        }
        return collisions;
    }
}
