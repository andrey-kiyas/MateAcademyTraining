package MateAcademy;

import java.util.Arrays;

public class MateAcademy_04_ELSE {
    public static void main(String[] args) {

//        System.out.println(growPlant(6, 5, 5));
//        System.out.println(growPlant(7, 7, 7));

//        System.out.println(isSquare(2));  // false
//        System.out.println(isSquare(16)); // true // 4 * 4 = 16
//        System.out.println(isSquare(-4)); // false // від'ємні числа не є квадратними числами

//        System.out.println(convertString("Mate Academy"));  // == 'mate academy'
//        System.out.println(convertString("Mate ACADEmy"));  // == 'MATE ACADEMY'
//        System.out.println(convertString("maTE"));  // == 'mate'

//        System.out.println(Arrays.toString(separateWheatFromChaff(new long[]
//                {7, -8, 1, -2}))); // == {-2, -8, 1, 7}
//        System.out.println(Arrays.toString(separateWheatFromChaff(new long[]
//                {-31, -5, 11 , -42, -22, -46, -4, -28}))); // == {-31, -5,- 28, -42, -22, -46 , -4, 11}

//        System.out.println(isPrime("abc")); // ==> true
//        System.out.println(isPrime("mama")); // ==> false
//        System.out.println(isPrime("u")); // ==> true

        // -----------------------------


    }

    public static boolean isPrime(String string) {
        // write code here
        return (string + string).indexOf(string, 1) == string.length();
    }

    public static long[] separateWheatFromChaff(long[] nums) {
        // write code here
        nums = Arrays.copyOf(nums, nums.length);
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (nums[left] > 0 && left < right) {
                if (nums[right--] < 0) {
                    nums[left] += nums[right + 1] - (nums[right + 1] = nums[left]);
                }
            }
        }
        return nums;
    }

    public static String convertString(String string) {
        // write code here
        int isUpper = 0;
        char[] charArray = string.toCharArray();
        for (char chars : charArray) {
            if (Character.isUpperCase(chars)) {
                isUpper++;
            }
            if (Character.isLowerCase(chars)) {
                isUpper--;
            }
        }
        return (isUpper > 0) ? string.toUpperCase() : string.toLowerCase();
    }

    public static boolean isSquare(int number) {
        // write code here
        return Math.sqrt(number) % 1 == 0;
    }

    public static int growPlant(int upSpeed, int downSpeed, int desiredHeight) {
        // write code here
        int colDays = 1;
        int plantHeight = 0;
        while (desiredHeight > plantHeight) {
            plantHeight += upSpeed;
            if (desiredHeight <= plantHeight) {
                return colDays;
            }
            plantHeight -= downSpeed;
            if (desiredHeight <= plantHeight) {
                return colDays;
            }
            colDays++;
        }
        return 0;
    }
}
