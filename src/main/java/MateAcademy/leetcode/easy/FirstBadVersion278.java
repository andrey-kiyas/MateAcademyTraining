package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/first-bad-version
 */

public class FirstBadVersion278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int a) {
        return a == 4;
    }
}
