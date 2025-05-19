package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/type-of-triangle/description
 */

public class LC3024TypeOfTriangle {
    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{3, 3, 3}));   // equilateral
        System.out.println(triangleType(new int[]{3, 4, 5}));   // scalene
        System.out.println(triangleType(new int[]{1, 2, 3}));   // none
        System.out.println(triangleType(new int[]{3, 3, 5}));   // isosceles
    }

    public static String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        }

        if (a == b || b == c || a == c) {
            return "isosceles";
        }

        return "scalene";
    }
}
