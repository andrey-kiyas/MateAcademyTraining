package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/total-waviness-of-numbers-in-range-i
 */

public class LC3751TotalWavinessOfNumbersInRangeI {
    public static void main(String[] args) {
        System.out.println(totalWaviness(120, 130));   // 3
        System.out.println(totalWaviness(198, 202));   // 3
        System.out.println(totalWaviness(4848, 4848)); // 2
    }

    public static int totalWaviness(int num1, int num2) {
        int totalSum = 0;

        for (int i = num1; i <= num2; i++) {
            totalSum += calculateWaviness(i);
        }

        return totalSum;
    }

    private static int calculateWaviness(int num) {
        String s = Integer.toString(num);
        int len = s.length();

        if (len < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < len - 1; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + 1);

            if (curr > prev && curr > next) {
                count++;
            }
            else if (curr < prev && curr < next) {
                count++;
            }
        }

        return count;
    }
}
