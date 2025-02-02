package MateAcademy.leetcode.easy;

public class LC1752CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,5,1,2})); // true
        System.out.println(check(new int[]{2,1,3,4}));   // false
        System.out.println(check(new int[]{1,2,3}));     // true
    }

    public static boolean check(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                ++count;
            }
        }

        return (count <= 1);
    }
}
