package MateAcademy.code_test;

import java.util.Arrays;

public class Pairs {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, -3, -3};
        System.out.println(findPairs(nums));
    }

    public static int findPairs(int[] nums) {
        int numberOfPairs = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                numberOfPairs++;
                i++;
            }
        }
        return numberOfPairs;
    }

    public static int findPairs2(int[] nums) {
        // write code here
        int varInt = 0;
        boolean isPair = false;
        int count = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (varInt != nums[i] && isPair) {
                continue;
            }
            if (varInt != nums[i] && !isPair) {
                varInt = nums[i];
            }
            if (varInt == nums[i]) {
                isPair = true;
                count++;
                if (count == 2) {
                    result++;
                    count = 0;
                }
            }
        }
        return result;
    }
}
