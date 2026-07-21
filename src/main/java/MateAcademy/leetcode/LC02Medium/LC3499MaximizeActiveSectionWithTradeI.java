package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximize-active-section-with-trade-i
 */

public class LC3499MaximizeActiveSectionWithTradeI {
    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01"));      // 1
        System.out.println(maxActiveSectionsAfterTrade("0100"));    // 4
        System.out.println(maxActiveSectionsAfterTrade("1000100")); // 7
        System.out.println(maxActiveSectionsAfterTrade("01010"));   // 4
    }

    public static int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        List<Integer> zeroBlocks = new ArrayList<>();

        int n = s.length();
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int length = j - i;

            if (s.charAt(i) == '1') {
                initialOnes += length;
            } else {
                zeroBlocks.add(length);
            }

            i = j;
        }

        int maxTradeGain = 0;
        for (int k = 0; k < zeroBlocks.size() - 1; k++) {
            maxTradeGain = Math.max(maxTradeGain, zeroBlocks.get(k) + zeroBlocks.get(k + 1));
        }

        return initialOnes + maxTradeGain;
    }
}
