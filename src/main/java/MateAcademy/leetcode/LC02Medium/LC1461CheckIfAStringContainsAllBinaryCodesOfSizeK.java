package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k
 */

public class LC1461CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
            System.out.println(hasAllCodes("00110110", 2)); // true
            System.out.println(hasAllCodes("0110", 1));     // true
            System.out.println(hasAllCodes("0110", 2));     // false
    }

    public static boolean hasAllCodes(String s, int k) {
        int requiredCount = 1 << k;

        if (s.length() < requiredCount + k - 1) {
            return false;
        }

        Set<String> seenCodes = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            seenCodes.add(sub);

            if (seenCodes.size() == requiredCount) {
                return true;
            }
        }

        return seenCodes.size() == requiredCount;
    }
}
