package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/find-the-punishment-number-of-an-integer
 */

public class LC2698FindThePunishmentNumberOfAnInteger {
    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));  // 182
        System.out.println(punishmentNumber(37));  // 1478
    }

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (isValidPartition(String.valueOf(square), 0, i)) {
                sum += square;
            }
        }
        return sum;
    }

    private static boolean isValidPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        int num = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0'); // Формуємо число з підстроки
            if (num > target) {
                break; // Оптимізація: якщо перевищили ціль, зупиняємось
            }
            if (isValidPartition(s, i + 1, target - num)) {
                return true;
            }
        }
        return false;
    }
}
