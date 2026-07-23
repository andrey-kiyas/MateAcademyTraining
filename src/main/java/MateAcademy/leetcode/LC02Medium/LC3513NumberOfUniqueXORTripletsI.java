package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-unique-xor-triplets-i
 */

public class LC3513NumberOfUniqueXORTripletsI {
    public static void main(String[] args) {
        System.out.println(uniqueXorTriplets(new int[]{1, 2}));    // 2
        System.out.println(uniqueXorTriplets(new int[]{3, 1, 2})); // 4
    }

    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int highestBit = Integer.highestOneBit(n);
        return highestBit << 1;
    }
}
