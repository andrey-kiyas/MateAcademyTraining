package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-unique-xor-triplets-ii
 */

public class LC3514NumberOfUniqueXORTripletsII {
    public static void main(String[] args) {
        System.out.println(uniqueXorTriplets(new int[]{1, 2}));    // 2
        System.out.println(uniqueXorTriplets(new int[]{3, 1, 2})); // 4
    }

    public static int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }
        limit <<= 1;

        boolean[] uniquePairs = new boolean[limit];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                uniquePairs[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] uniqueTriplets = new boolean[limit];
        for (int pairXor = 0; pairXor < limit; pairXor++) {
            if (uniquePairs[pairXor]) {
                for (int x : nums) {
                    uniqueTriplets[pairXor ^ x] = true;
                }
            }
        }

        int distinctCount = 0;
        for (int i = 0; i < limit; i++) {
            if (uniqueTriplets[i]) {
                distinctCount++;
            }
        }

        return distinctCount;
    }
}
