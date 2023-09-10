package MateAcademy.codewars;

import java.util.Arrays;

public class SolutionTwoSum {
    public static void main(String[] args) {
//        int[] numbers = {2, 3, 3, 3, 7, 9, 9, 17, 19, 31, 32, 40, 52, 52};
//        int target = 38;
//        int[] numbers = new int[]{2, 3, 1};
//        int target = 4;
        int[] numbers = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
//        int[] sortedInts = Arrays.stream(numbers)
//                .distinct()
//                .sorted().toArray();
        int l = 0;
        int r = numbers.length - 1;
        int sum = 0;
        int targ = Math.abs(target);

        while (l <= r) {
            sum = Math.abs(numbers[l]) + Math.abs(numbers[r]);
//            System.out.println("Element " + l + "(" + numbers[l] + ")" + " & " + "Element " + r + "(" + numbers[r] + ")");
            if (sum > targ) {
                r--;
            }
            if (sum < targ) {
                l++;
            }
            if (sum == targ) {
                return new int[]{l, r};
            }
        }
        return new int[]{l, r};
    }
}