package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters
 */

public class LC0717OneBitAndTwoBitCharacters {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1,0,0}));   // true
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0})); // false
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == bits.length - 1;
    }
}
