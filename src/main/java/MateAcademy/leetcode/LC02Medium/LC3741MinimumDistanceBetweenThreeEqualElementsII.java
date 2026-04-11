package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii
 */

public class LC3741MinimumDistanceBetweenThreeEqualElementsII {
    public static void main(String[] args) {
        System.out.println(minimumDistance(new int[]{1, 2, 1, 1, 3}));       // 6
        System.out.println(minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2})); // 8
        System.out.println(minimumDistance(new int[]{1}));                   // -1
    }

    public static int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int k = 0; k < nums.length; k++) {
            int val = nums[k];
            if (map.containsKey(val)) {
                int[] indices = map.get(val);
                int last = indices[0];
                int prev = indices[1];

                if (prev != -1) {
                    int distance = 2 * (k - prev);
                    minDistance = Math.min(minDistance, distance);
                    found = true;
                }

                indices[1] = last;
                indices[0] = k;
            } else {
                map.put(val, new int[]{k, -1});
            }
        }

        return found ? minDistance : -1;
    }
}
