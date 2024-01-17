package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/container-with-most-water
 */

public class ContainerWithMostWater11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,4,3}));                   // 4
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                      // 1
        System.out.println(maxArea(new int[]{1, 2, 1}));                   // 2
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int currentArea = h * w;
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int minIndex = 0;
        int maxIndex = height.length - 1;
        for (int i = 0; i < height.length - 3; i++) {
            if (height[i] > height[minIndex]) {
                minIndex = i;
            }
            if (height[i] < height[minIndex]) {
                break;
            }
        }
        for (int i = height.length - 1; i > 2; i--) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
            if (height[i] < height[maxIndex]) {
                break;
            }
        }
        return Math.min(height[minIndex], height[maxIndex]) * (maxIndex - minIndex);
    }
}
