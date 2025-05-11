package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/three-consecutive-odds
 */

public class LC1550ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 1};
        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        System.out.println(threeConsecutiveOdds(arr1)); // false
        System.out.println(threeConsecutiveOdds(arr2)); // true
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 == 1) {
                count++;
                if (count == 3) return true;
            } else {
                count = 0;
            }
        }

        return false;
    }
}
