package MateAcademy.code_test;

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {7, 6, 7};              // ==> 7
        int[] nums = {2, 2, 1, 1, 2, 1, 2};  // ==> 2
        System.out.println("The majority element is " + findMajor(nums));
    }

    public static int findMajor(int[] nums) {
        int m = -1;
        int i = 0;
        for (int num : nums) {
            if (i == 0) {
                m = num;
                i = 1;
            } else if (m == num) {
                i++;
            } else {
                i--;
            }
        }
        return m;
    }
}
