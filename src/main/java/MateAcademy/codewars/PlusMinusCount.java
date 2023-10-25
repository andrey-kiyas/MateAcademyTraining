package MateAcademy.codewars;

public class PlusMinusCount {

    public static void main(String[] args) {
        System.out.println(signChange(new int[]{1, 3, 4, 5}));
        System.out.println(signChange(new int[]{1, -3, -4, 0, 5}));
        System.out.println(signChange(new int[]{}));
        System.out.println(signChange(new int[]{-47, 84, -30, -11, -5, 74, 77}));
    }

    public static int signChange3(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] >= 0 && arr[i - 1] < 0) || (arr[i] < 0 && arr[i - 1] >= 0)) count++;
        }
        return count;
    }

    public static int signChange(int[] arr) {
        // your solution here
        int sign = (arr.length == 0) ? 0 : (arr[0] < 0) ? -1 : 1;
        int count = 0;
        for (int num : arr) {
            if (num >= 0 && sign < 0) {
                count++;
                sign *= -1;
            } else if (num < 0 && sign >= 0) {
                count++;
                sign *= -1;
            }
        }
        return count;
    }
}
