package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/process-string-with-special-operations-ii
 */

public class LC3614ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*", 1));   // 'a'
        System.out.println(processStr("cd%#*#", 3));  // 'd'
        System.out.println(processStr("z*#", 0));     // '.'
    }

    public static char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long currentLen = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                currentLen *= 2;
            } else if (ch == '*') {
                if (currentLen > 0) {
                    currentLen--;
                }
            } else if (ch == '%') {
            } else {
                currentLen++;
            }
            lengths[i] = currentLen;
        }

        if (k < 0 || k >= currentLen) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (ch == '#') {
                if (k >= prevLen) {
                    k %= prevLen;
                }
            } else if (ch == '*') {
            } else if (ch == '%') {
                long totalLen = lengths[i];
                k = (totalLen - 1) - k;
            } else {
                if (k == prevLen) {
                    return ch;
                }
            }
        }

        return '.';
    }
}
