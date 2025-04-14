package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-good-triplets
 */

public class LC1534CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3)); // Output: 4
        System.out.println(countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));    // Output: 0
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
