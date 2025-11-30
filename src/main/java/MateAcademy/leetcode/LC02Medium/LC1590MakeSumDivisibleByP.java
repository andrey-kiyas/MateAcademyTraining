package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/make-sum-divisible-by-p
 */

public class LC1590MakeSumDivisibleByP {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 6)); // 1
        System.out.println(minSubarray(new int[]{6, 3, 5, 2}, 9)); // 2
        System.out.println(minSubarray(new int[]{1, 2, 3}, 3));    // 0
    }

    public static int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;

        int rem = (int)(total % p);
        if (rem == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            int need = (int)((prefix - rem + p) % p);

            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }

            map.put((int)prefix, i);
        }

        return res == nums.length ? -1 : res;
    }
}
