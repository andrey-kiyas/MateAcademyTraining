package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-operations-to-obtain-zero
 */

public class LC2169CountOperationsToObtainZero {
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));   // 3
        System.out.println(countOperations(10, 10)); // 1
        System.out.println(countOperations(0, 5));   // 0
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
