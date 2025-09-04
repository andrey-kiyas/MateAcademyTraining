package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-closest-person
 */

public class LC3516FindClosestPerson {
    public static void main(String[] args) {
        System.out.println(findClosest(2, 7, 4)); // 1
        System.out.println(findClosest(2, 5, 6)); // 2
        System.out.println(findClosest(1, 5, 3)); // 0
    }

    public static int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);

        if (dist1 < dist2) {
            return 1;
        } else if (dist2 < dist1) {
            return 2;
        } else {
            return 0;
        }
    }
}
